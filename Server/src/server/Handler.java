/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ali
 */
class Handler implements Runnable{

        Socket connectedSocket;    
        Handler(Socket connectedSocket){
            this.connectedSocket = connectedSocket;
        }
    
       @Override
       public void run(){
           
            try {
                 DataInputStream inputStream = new DataInputStream(connectedSocket.getInputStream());
                 String str = inputStream.readUTF();
                 System.out.println("Client str : "+str);
                 DataOutputStream outputStream = new DataOutputStream(connectedSocket.getOutputStream());
                 outputStream.writeUTF("OK");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
}