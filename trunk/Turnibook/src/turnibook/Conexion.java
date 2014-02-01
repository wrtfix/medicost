package turnibook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.Configuration;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    protected final Properties properties;

    /**
     * Constructor for objects of class Conexion
     */
    public Conexion()
    {
        this.properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("base.properties"));
            ruta = this.properties.getProperty("direccion.base");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ""+ex.getMessage());
        }
        
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
