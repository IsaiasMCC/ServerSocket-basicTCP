
package com.mycompany.basic_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Isai
 */

public class Server implements ChangeEventListener {
    ServerSocket server;
    ListenClient threadListen;
    ListenData threadData;
    final int Port = 5000;

    public Server(){
        this.server = null;
    }
    
    public void initServer(){
        try{
           server = new ServerSocket(Port);
            System.out.println("Server started");
            this.threadListen = new ListenClient(server);
            threadListen.start();
        } catch (IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  

    @Override
    public void onConnectClient(ChangeEvent e) {
        this.threadData = new ListenData(e.getSocket());
        this.threadData.start();
        System.out.println("Thread created");
    }

}
