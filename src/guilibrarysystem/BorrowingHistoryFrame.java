package guilibrarysystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DataBase.Borrowing;
import DataBase.User;
import DataBase.book_CRUD;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author HQ
 */
public class BorrowingHistoryFrame extends javax.swing.JFrame {

    private User currentUser;
    File f = new File("C:/Users/96650/Documents/NetBeansProjects/Project305/BorrowingHistory.txt");
    PrintWriter out = new PrintWriter(new FileWriter(f,false));
    public BorrowingHistoryFrame(User user) throws IOException{
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.currentUser = user;
        initComponents();
        loadBorrowingHistory();
    }

    private void loadBorrowingHistory() {
        try {
            book_CRUD bookCrud = new book_CRUD();

            if (currentUser == null) {
                JOptionPane.showMessageDialog(this, "Error: User is not logged in.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Borrowing> history = bookCrud.getBorrowingHistory(currentUser.getId());
            if (history == null || history.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No borrowing history found.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Clear existing data

            for (Borrowing borrowing : history) {
                model.addRow(new Object[]{
                    borrowing.getBookTitle(),
                    borrowing.getBorrowDate() != null ? borrowing.getBorrowDate().toString() : "N/A",
                    borrowing.getReturnDate() != null ? borrowing.getReturnDate().toString() : "N/A"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load borrowing history: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PrintButton = new javax.swing.JButton();
        DownloadButton = new javax.swing.JButton();
        back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Borrowing History ");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Book 1", "2023-01-01", "2023-01-15"},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Book Title", "Date Borrowed", "Date Returned"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 159, 180));
        jScrollPane2.setViewportView(jTable1);

        PrintButton.setBackground(new java.awt.Color(240, 132, 147));
        PrintButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        PrintButton.setForeground(new java.awt.Color(255, 255, 255));
        PrintButton.setText("Print ");
        PrintButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintButtonMouseClicked(evt);
            }
        });
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        DownloadButton.setBackground(new java.awt.Color(240, 132, 147));
        DownloadButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        DownloadButton.setForeground(new java.awt.Color(255, 255, 255));
        DownloadButton.setText("Download");
        DownloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadButtonActionPerformed(evt);
            }
        });

        back1.setBackground(new java.awt.Color(51, 51, 51));
        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-arrow (2).png"))); // NOI18N
        back1.setToolTipText("");
        back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back1MouseClicked(evt);
            }
        });
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(483, 483, 483)
                        .addComponent(DownloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back1)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DownloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DownloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadButtonActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_DownloadButtonActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back1ActionPerformed

    private void back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseClicked
        // TODO add your handling code here:
        MainD main = new MainD(currentUser);
        main.initialize();
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);//to the center
        this.dispose();
    }//GEN-LAST:event_back1MouseClicked

    private void PrintButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintButtonMouseClicked
        // TODO add your handling code here:
        String Header;
        Date currentDate = new Date();
        book_CRUD bookCrud = new book_CRUD();
        List<Borrowing> history = bookCrud.getBorrowingHistory(currentUser.getId());
        Header = 
                     ("****************************************************************\n"+
                      "                     Welcome to KAU Library\n"+
                      "***************************************************************\n\n\n"+
                      "====================YOUR Borrowing History====================\n"+
                      "====================User Information===========================\n"+
                      "User Name: "+currentUser.getUsername()+"\n"+
                      "number: "+currentUser.getPhoneNumber()+"\n"+
                      "time of issue: "+currentDate+"\n\n"+
                      "===============borrowed books history===============\n");
        
                     out.printf(Header+"%-30s %-20s%n", "Book Title", "Borrowing Date\n"+
                      "---------------------------------------------------");
                     for (Borrowing borrowing : history) {
                         out.printf("%-30s %-20s%n", borrowing.getBookTitle(),borrowing.getBorrowDate()+"\n");
                         Header+= borrowing.getBookTitle()+"    "+borrowing.getBorrowDate()+"\n";
                    };
                    out.close();
                     JOptionPane.showMessageDialog(this, Header, "Error", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PrintButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BorrowingHistoryFrame().setVisible(true);
//            }
//        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DownloadButton;
    private javax.swing.JButton PrintButton;
    private javax.swing.JButton back1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
