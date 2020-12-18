
package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ali
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket connectedSocket = serverSocket.accept();
        Thread thread = new Thread(new Handler(connectedSocket),"myThread");
        thread.start();

        connectedSocket.close();
        serverSocket.close();
    }
      catch(IOException e){
          e.printStackTrace();
      }    
        
        
}
}

