/*
 * To change this template, choose Tools | Templates


* and open the template in the editor.
 */
package turnibook;


import java.sql.Time;
import Vista.consultaTurnosUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class Operaciones extends Conexion{
    //Cada numero representa la columna de la tabla
    private static int ASISTENCIA = 6;
    private static int DESCRIPCION = 5;
    private static int OS = 4;
    private static int TEL = 3;
    private static int DOC = 2;
    private static int NOMBRE = 1;
    private static int HORA = 0;
    private String id_horario;
    private String id_profesional;

    /**
     * Constructor for objects of class Operaciones
     */
    public Operaciones()
    {
        super();
    }
    
    public boolean insertar(String sql,JTextField aviso) {
        boolean valor = true;
        conectar();
        try {
            consulta.executeUpdate(sql);
           // JOptionPane.showMessageDialog(null, sql);
           //Mostrar cartelito abajo q se cargo correctamente
          aviso.setText("Los datos se guardaron correctamente");
        } catch (SQLException e) {
            valor = false;
            //JOptionPane.showMessageDialog(null, e.getMessage());
           
            aviso.setText("No se inserto correctamente,intente nuevamente");
        } finally {
            try {
                consulta.close();
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valor;
    }
    
    public void borrarTurno(String hora,String fecha,String id ){
        
        conectar();
        try {
            String sql="delete from turno where fecha = '"+fecha+"' and hora ='"+hora+"' and id_profesional='"+id+"'";
            consulta.executeQuery(sql);            
        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
               // JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }       
    }
    
    public ResultSet consultar(String sql){
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);
            
        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
              //  JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        
        return resultado;
        
    }
    
      public String IdHorario(String id_profesional){
        conectar();
        ResultSet resultado;
        try {
            String sql = "select id_horario from profesional where id_profesional='"+id_profesional+"'";
            resultado = consulta.executeQuery(sql);
            String ret = "";
            if(resultado.next()){
                 ret = resultado.getString("id_horario");
            }
            consulta.close();
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
        public String ultimoIdHorario(){
        conectar();
        ResultSet resultado;
        try {
            String sql = "select max(id_horario) from horario";
            resultado = consulta.executeQuery(sql);
            String ret = "";
            if(resultado.next()){
                 ret = resultado.getString(1);
            }
            consulta.close();
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean existeTurno(String fecha, String hora){
        conectar();
        ResultSet resultado;
        
        try {
            resultado = consulta.executeQuery("select hora from turno where fecha = '"+fecha+"' and hora ='"+hora+"'");
            if (resultado.next()){
                consulta.close();
                return true;
            }else{
                consulta.close();
                return false;
                
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
            
    public ResultSet getTurnos(String fecha, String id_profesional){
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery("select * from turno where fecha = '"+fecha+"' and id_profesional='"+id_profesional+"'");
            consulta.close();
       }
        catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public void close(){
        try {
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getIntervalo(String dia, String id_horario){
        conectar();
        ResultSet resultado = null;
        String intervalo ="";
        try {
            resultado = consulta.executeQuery("select "+dia+"_desde, "+dia+"_hasta , intervalo from horario where id_horario="+id_horario);
            if (resultado.next())
                intervalo = resultado.getString(dia+"_desde") +"-"+resultado.getString(dia+"_hasta")+"-"+resultado.getString("intervalo");
            else 
                intervalo = "fin";
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return intervalo;
    }
    
    
    public void generarHorario(String inicio, String fin,Integer intervalo, JTable tablaAgenda, String id_profesional, String fecha){
        
       Integer h_inicio;
       Integer m_inicio=0;
       Integer h_fin;
       Integer m_fin=0;
       
       
       if (inicio.contains(":")){
           String[] aux = inicio.split(":");
           h_inicio=Integer.valueOf(aux[0]);
           m_inicio=Integer.valueOf(aux[1]);
       }
       else{
           h_inicio=Integer.valueOf(inicio);
       }
         if (fin.contains(":")){
           String[] aux = inicio.split(":");
           h_fin=Integer.valueOf(aux[0]);
           m_fin=Integer.valueOf(aux[1]);
       }
         else{
           h_fin=Integer.valueOf(fin);
         }
        
        
        tablaAgenda.setEnabled(true);
        int i=0;
        int fila=0;
        int aux=m_inicio;
        String hora;   
        
        DefaultTableModel model = (DefaultTableModel) tablaAgenda.getModel();
        model.setRowCount(0);
        conectar();
        ResultSet res = null;
        try {
            res = consulta.executeQuery("select * from turno where fecha ='"+fecha+"' and id_profesional ='"+id_profesional+"'");
        while(h_inicio < h_fin){
            if (aux != 0) {
                if (aux==60){
                    hora = h_inicio+1 + ":00";
                }else
                    hora = h_inicio + ":" + aux;
            } else {
                hora = h_inicio + ":00";
            }
            model.addRow(new Object[7]);
            model.setValueAt(hora,fila,HORA); 
            try {
                if(res.next() && res.getString("nombre")!=null && hora.equals(res.getString("hora"))){
                    if(!"null".equals(res.getString("documento"))){
                         model.setValueAt(res.getString("documento"),fila,DOC);
                    }
                    if(!"null".equals(res.getString("telefono"))){
                         model.setValueAt(res.getString("telefono"),fila,TEL); 
                    }
                    if(!"null".equals(res.getString("descripcion"))){
                        model.setValueAt(res.getString("descripcion"),fila,DESCRIPCION);
                    }
                    if(!"null".equals(res.getString("nombre"))){
                        model.setValueAt(res.getString("nombre"),fila,NOMBRE);
                    }
                    if(!"null".equals((res.getString("os")))){
                        model.setValueAt(res.getString("os"),fila,OS);
                    }                                 
                                     
                    if ("true".equals(res.getString("Asistencia"))) {
                        model.setValueAt(true,fila,ASISTENCIA);
                    } 
                    else {
                        model.setValueAt(false,fila,ASISTENCIA);
                    } 
                     
                     
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(consultaTurnosUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux + intervalo;
            if (aux > 60) {
                aux = aux - 60;
                h_inicio = h_inicio + 1;
                
            }
            fila++;
            i++;
        }
        consulta.close();
       }
        
        catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public String getIdProfesional(String nombre,String mail){
        conectar();
        ResultSet resultado;
        try {
            resultado = consulta.executeQuery("select max(id_profesional) from profesional");
            String ret = resultado.getString(1);
            consulta.close();
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public ResultSet getHorarios(String id_horario){
        conectar();
        ResultSet resultado = null;
        try {
            String sql = "select * from horario where id_horario = '"+id_horario+"'";
            resultado = consulta.executeQuery(sql);
            return resultado;
       }
        catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public void eliminarProfesional(String id_profesional){
        conectar();
        ResultSet res = null;
        try {
            String sql = "delete from profesional where id_profesional='"+id_profesional+"'";
            res = consulta.executeQuery(sql);
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void eliminarHorario(String id_horario){
        conectar();
        ResultSet res = null;
        try {
            String sql = "delete from horario where id_horario='"+id_horario+"'";
            res = consulta.executeQuery(sql);
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean existeProfesional(String id_profesional) {
        conectar();
        ResultSet resultado;

        try {
            String sql = "select * from profesional where id_profesional='" + id_profesional + "'";
            resultado = consulta.executeQuery(sql);
            if (resultado.next()) {
                consulta.close();
                return true;
            } else {
                consulta.close();
                return false;

            }


        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    /**
     * Este metodo valida si el usuario es o no valido a traves de una propertie.
     * @param nombre
     * @param pass
     * @return 
     */
    public boolean validarUsuario(String nombre, String pass) {
        return nombre.equals(this.properties.getProperty("admin.user")) &&  pass.equals(this.properties.getProperty("admin.password"));
    }
}