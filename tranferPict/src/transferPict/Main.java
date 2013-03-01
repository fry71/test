/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transferPict;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d.fedorov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            XML_Reader xmL_Reader = new XML_Reader();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
