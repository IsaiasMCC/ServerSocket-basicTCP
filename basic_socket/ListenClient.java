
package com.mycompany.basic_socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.ListIterator;
/**
 *
 * @author Isai
 */
public class ListenClient extends Thread {
    ServerSocket server;
    Socket client;
    private static ArrayList listeners;

    public ListenClient(ServerSocket server) {
        this.server = server;
    }
    
    
    @Override
    public void run(){
        while(true){
            try{
                client = server.accept();
                ChangeEvent readerEvObj = new ChangeEvent(this, this.server);
                System.out.println("Client connected");
            }
           catch (IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    private void addEventListener(ChangeEventListener listener){
        listeners.add(listener);
    }
    private void triggerClientConnect(){
        ListIterator li = listeners.listIterator();
        while(li.hasNext()){
            ChangeEventListener listener = (ChangeEventListener)li.next();
            ChangeEvent readerEvObj = new ChangeEvent(this, this.server);
            (listener).onConnectClient(readerEvObj);
        }
    }
    
    
}
