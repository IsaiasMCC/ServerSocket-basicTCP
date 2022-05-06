
package com.mycompany.basic_socket;

import java.net.ServerSocket;
import java.util.EventObject;

/**
 *
 * @author Isai
 */
public class ChangeEvent extends EventObject{
    ServerSocket socket;
    public ChangeEvent(Object source, ServerSocket _socket){
        super(source);
        socket = _socket;
    }
    public ServerSocket getSocket(){
        return socket;
    }
}
