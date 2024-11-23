/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;
// server

/**
 *
 * @author reaho
 */
import DataBase.Book;
import DataBase.book_CRUD; // Import the book_CRUD class
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LibraryServer {

    private static final int PORT = 12345;
    private ServerSocket serverSocket;
    private ExecutorService threadPool;

    public LibraryServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        threadPool = Executors.newFixedThreadPool(10); // Max 10 concurrent clients
    }

    public void start() {
        System.out.println("Library Server started on port " + PORT);

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                if (!serverSocket.isClosed()) {
                    e.printStackTrace();
                }
            }
        }

        shutdown();
    }

    private void shutdown() {
        try {
            threadPool.shutdown();
            serverSocket.close();
            System.out.println("Server shut down gracefully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

                String request = (String) in.readObject();
                System.out.println("Received request: " + request);

                if (request.startsWith("BORROW_BOOK")) {
                    handleBorrowBookRequest(request, out);
                } else if (request.startsWith("RETURN_BOOK")) {
                    handleReturnBookRequest(request, out);
                } else if (request.startsWith("SEARCH_BOOK")) { // Add handling for SEARCH_BOOK
                    handleSearchBookRequest(request, out);
                } else {
                    out.writeObject("ERROR: Invalid Request");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void handleSearchBookRequest(String request, ObjectOutputStream out) {
            try {
                String[] parts = request.split("\\|");
                

                if (parts.length < 2) {
                    out.writeObject("ERROR: Malformed SEARCH_BOOK request.");
                    return;
                }
                                           //mod
                String bookTitle = parts[1].trim();            //mod
                String bookAuthor = parts.length > 2 ? parts[2].trim()  : "";

                // Perform search using book_CRUD
                book_CRUD bookCrud = new book_CRUD();
                Book foundBook = bookCrud.searchBook(bookTitle, bookAuthor);

                if (foundBook != null) {
                    // Send book details back to client
                   
                     out.writeObject("SUCCESS|" + foundBook.getId() + "|" + foundBook.getBookname() + "|" + foundBook.getAuthor() + "|" + foundBook.getStatus() + "|" + foundBook.getQuantity());

                } else {
                    out.writeObject("ERROR: Book not found.");
                }
            } catch (Exception e) {
                try {
                    out.writeObject("ERROR: " + e.getMessage());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
        }

        private void handleBorrowBookRequest(String request, ObjectOutputStream out) {
            try {
                String[] parts = request.split("\\|");
                if (parts.length < 5) {
                    out.writeObject("ERROR: Malformed BORROW_BOOK request.");
                    return;
                }

                int bookId = Integer.parseInt(parts[1]);
                int userId = Integer.parseInt(parts[2]);
                String borrowDate = parts[3];
                String returnDate = parts[4];

                book_CRUD bookCrud = new book_CRUD();
                int borrowId = bookCrud.getNextBorrowingId();
                bookCrud.borrowBook(borrowId, bookId, userId, borrowDate, returnDate);
                out.writeObject("SUCCESS");
            } catch (Exception e) {
                try {
                    out.writeObject("ERROR: " + e.getMessage());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
        }

        private void handleReturnBookRequest(String request, ObjectOutputStream out) {
            try {
                String[] parts = request.split("\\|");
                if (parts.length < 3) {
                    out.writeObject("ERROR: Malformed RETURN_BOOK request.");
                    return;
                }

                int userId = Integer.parseInt(parts[1]);
                String bookName = parts[2];

                if (book_CRUD.returnBook(userId, bookName)) {
                    out.writeObject("SUCCESS");
                } else {
                    out.writeObject("ERROR: Failed to return the book.");
                }
            } catch (Exception e) {
                try {
                    out.writeObject("ERROR: " + e.getMessage());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
        }

    }
}
