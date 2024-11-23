/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

/**
 *
 * @author reaho
 */
import java.io.*;
import java.net.Socket;

public class LibraryClient implements AutoCloseable {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public LibraryClient(String host, int port) throws IOException {
        // Initialize socket with a timeout of 10 seconds
        socket = new Socket(host, port);
        socket.setSoTimeout(10000); // Set timeout for socket read operations
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public String sendRequest(String request) throws IOException, ClassNotFoundException {
        if (request == null || request.isEmpty()) {
            throw new IllegalArgumentException("Request cannot be null or empty.");
        }

        out.writeObject(request);
        Object response = in.readObject();
        if (response instanceof String) {
            return (String) response;
        } else {
            throw new IOException("Unexpected response from server.");
        }
    }

    @Override
    public void close() throws IOException {
        if (in != null) in.close();
        if (out != null) out.close();
        if (socket != null) socket.close();
    }

}
