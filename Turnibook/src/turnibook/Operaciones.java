/*
 * To change this template, choose Tools | Templates


* and open the template in the editor.
 */
package turnibook;


import Vista.consultaTurnosUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    
    public boolean insertar(String sql) {
        boolean valor = true;
        conectar();
        try {
            consulta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        } catch (SQLException e) {
            valor = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    //hacer q borre!
    public void borrar(String hora,String fecha,String id ){
        
        conectar();
        try {
            String sql="delete from turno where fecha = '"+fecha+"' and hora ='"+hora+"' and id_profesional='"+id+"'";
            consulta.executeQuery(sql);            
        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
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
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
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
                intervalo = resultado.getString(dia+"_desde") +":"+resultado.getString(dia+"_hasta")+":"+resultado.getString("intervalo");
            else 
                intervalo = "fin";
            consulta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return intervalo;
    }
    
    
    public void generarHorario(Integer inicio, Integer fin,Integer intervalo, JTable tablaAgenda, String id_profesional, String fecha){
        tablaAgenda.setEnabled(true);
        int i=0;
        int fila=0;
        int aux=0;
        String hora;   
        
        DefaultTableModel model = (DefaultTableModel) tablaAgenda.getModel();
        model.setRowCount(0);
        conectar();
        ResultSet res = null;
        try {
            res = consulta.executeQuery("select * from turno where fecha ='"+fecha+"' and id_profesional ='"+id_profesional+"'");
        while(inicio<fin){
            if (aux != 0) {
                if (aux==60){
                    hora = inicio+1 + ":00";
                }else
                    hora = inicio + ":" + aux;
            } else {
                hora = inicio + ":00";
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
                inicio = inicio + 1;
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
   
}