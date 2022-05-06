
package com.mycompany.basic_socket;

import java.util.EventListener;

/**
 *
 * @author Isai
 */
  interface ChangeEventListener extends EventListener {
    
    void onConnectClient(ChangeEvent e);
    
}
