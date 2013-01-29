package turnibook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a description of class Conexion here.
 * 
 * @author Rey Salcedo 
 * @version (a version number or a date)
 */
public class Conexion{
	Connection conexion;
	Statement consulta;
	public String ruta;

    /**
     * Constructor for objects of class Conexion
     */
    public Conexion()
    {
        ruta = "clinica";
    }
    public void conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
                   conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
                   consulta = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
