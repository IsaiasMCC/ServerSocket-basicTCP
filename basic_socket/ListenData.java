
package com.mycompany.basic_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
/**
 *
 * @author Isai
 */
public class ListenData extends Thread {
    ServerSocket socket;
    Socket client;
    DataInputStream inputStr;
    
    public ListenData(ServerSocket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                
            this.client =  socket.accept();
            this.inputStr = new DataInputStream(client.getInputStream());
            System.out.println("listen client");
            
            }
          catch (IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    }
}
