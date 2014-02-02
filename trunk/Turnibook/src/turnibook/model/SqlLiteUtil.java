package turnibook.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.Configuration;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta clase maneja la sesion de la base de datos
 *
 * @author Jorge Mendiola
 * @version 1.0
 */
public class SqlLiteUtil {

    private Connection conexion;
    private Statement consulta;
    public String ruta;
    protected final Properties properties;
    private static SqlLiteUtil INSTANCE = null;
    private String user = null;
    private String pass = null;
    
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SqlLiteUtil();
        }

    }    
    public static SqlLiteUtil getInstance() {
        createInstance();
        return INSTANCE;
    }
    /**
     * Constructor for objects of class SqlLiteUtil
     */
    private SqlLiteUtil() {
        this.properties = new Properties();
        try {                                                       
            properties.load(this.getClass().getResourceAsStream("../resources/configuration.properties"));
            ruta = this.properties.getProperty("direccion.base");
            user = this.properties.getProperty("admin.user");
            pass = this.properties.getProperty("admin.password");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }

    }

    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            consulta = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SqlLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar(){
        try {
            consulta.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(SqlLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet query(String sql){
        try {
            ResultSet resultado = consulta.executeQuery(sql);
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(SqlLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insert(String sql){
        try {
            int resultado = consulta.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SqlLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean update(String sql){
        try {
            return consulta.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SqlLiteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }
    
}
