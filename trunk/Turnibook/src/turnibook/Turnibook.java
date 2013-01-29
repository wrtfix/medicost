/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnibook;

import Vista.Login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author wrtfix
 */
public class Turnibook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login l = new Login();
        l.setLocationRelativeTo(null);
        l.setVisible(true);
        
        /*try {
            Operaciones c = new Operaciones();
            System.out.println(c.consultar("select * from paciente").getString(3).toString());
            System.out.println("Probando");
        } catch (SQLException ex) {
            Logger.getLogger(Turnibook.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
