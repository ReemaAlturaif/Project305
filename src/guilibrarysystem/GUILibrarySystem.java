
package guilibrarysystem;

import DataBase.DB_setUP;
import Network.LibraryServer;
import java.io.IOException;



public class GUILibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DB_setUP.CreateDatabase();
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();

        LoginFrame.setLocationRelativeTo(null);//to the center
        try {
            new LibraryServer().start();
        } catch (IOException e) {
            System.out.println("Failed to start the server: " + e.getMessage());
        }

}
}