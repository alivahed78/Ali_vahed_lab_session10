/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ali
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Socket socket = new Socket("localHost",5000);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("Hello Server");
        
        
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String str = inputStream.readUTF();
        System.out.println(str);
        outputStream.flush();
        outputStream.close();
        socket.close();
 
    }
        
    catch(IOException e){
        e.printStackTrace();
    }       
    
}
}
