/*
 * To change this template, choose Tools | Templates


 * and open the template in the editor.
 */
package turnibook.model;

import turnibook.view.consultaTurnosUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Operaciones {
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
    private final static Logger LOGGER = Logger.getLogger(Operaciones.class.getName());

    /**
     * Constructor for objects of class Operaciones
     */
    public Operaciones() {
        super();
    }

    public boolean insertar(String sql, JTextField aviso) {
        boolean valor = true;
        SqlLiteUtil.getInstance().conectar();
        SqlLiteUtil.getInstance().insert(sql);
        aviso.setText("Los datos se guardaron correctamente");
        SqlLiteUtil.getInstance().desconectar();
        return valor;
    }

    public void borrarTurno(String hora, String fecha, String id) {
        SqlLiteUtil.getInstance().conectar();
        String sql = "delete from turno where fecha = '" + fecha + "' and hora ='" + hora + "' and id_profesional='" + id + "'";
        SqlLiteUtil.getInstance().query(sql);
        SqlLiteUtil.getInstance().desconectar();
    }

    public ResultSet consultar(String sql) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado = null;
        resultado = SqlLiteUtil.getInstance().query(sql);
        return resultado;
    }

    public String IdHorario(String id_profesional) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado;
        String sql = "select id_horario from profesional where id_profesional='" + id_profesional + "'";
        resultado = SqlLiteUtil.getInstance().query(sql);
        String ret = "";
        try {
            if (resultado.next()) {
                ret = resultado.getString("id_horario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        SqlLiteUtil.getInstance().desconectar();
        return ret;
    }

    public String ultimoIdHorario() {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado;
        String sql = "select max(id_horario) from horario";
        resultado = SqlLiteUtil.getInstance().query(sql);
        String ret = "";
        try {
            if (resultado.next()) {
                ret = resultado.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        SqlLiteUtil.getInstance().desconectar();
        return ret;
    }

    public boolean existeTurno(String fecha, String hora) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado;
        resultado = SqlLiteUtil.getInstance().query("select hora from turno where fecha = '" + fecha + "' and hora ='" + hora + "'");
        try {
            if (resultado.next()) {
                SqlLiteUtil.getInstance().desconectar();
                return true;
            } else {
                SqlLiteUtil.getInstance().desconectar();
                return false;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        SqlLiteUtil.getInstance().desconectar();
        return false;
    }

    public ResultSet getTurnos(String fecha, String id_profesional) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado = null;
        resultado = SqlLiteUtil.getInstance().query("select * from turno where fecha = '" + fecha + "' and id_profesional='" + id_profesional + "'");
        SqlLiteUtil.getInstance().desconectar();
        return resultado;
    }

    public String getIntervalo(String dia, String id_horario) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado = null;
        String intervalo = "";
        try {
            resultado = SqlLiteUtil.getInstance().query("select " + dia + "_desde, " + dia + "_hasta , intervalo from horario where id_horario=" + id_horario);
            if (resultado.next()) {
                intervalo = resultado.getString(dia + "_desde") + "-" + resultado.getString(dia + "_hasta") + "-" + resultado.getString("intervalo");
            } else {
                intervalo = "fin";
            }
            SqlLiteUtil.getInstance().desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return intervalo;
    }
    public int getCantTurnos(ResultSet rs){
        int rowCount = 0;  
        try {
            while (rs.next())  
            {  
                rowCount++;  
            }
            return rowCount;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount;
    }
    
    public void generarHorario(String inicio, String fin, Integer intervalo, JTable tablaAgenda, String id_profesional, String fecha) {

        Integer h_inicio;
        Integer m_inicio = 0;
        Integer h_fin;
        Integer m_fin = 0;


        if (inicio.contains(":")) {
            String[] aux = inicio.split(":");
            h_inicio = Integer.valueOf(aux[0]);
            m_inicio = Integer.valueOf(aux[1]);
        } else {
            h_inicio = Integer.valueOf(inicio);
        }
        if (fin.contains(":")) {
            String[] aux = inicio.split(":");
            h_fin = Integer.valueOf(aux[0]);
            m_fin = Integer.valueOf(aux[1]);
        } else {
            h_fin = Integer.valueOf(fin);
        }


        tablaAgenda.setEnabled(true);
        int i = 0;
        int fila = 0;
        int aux = m_inicio;
        String hora;

        DefaultTableModel model = (DefaultTableModel) tablaAgenda.getModel();
        model.setRowCount(0);
        SqlLiteUtil.getInstance().conectar();

        ResultSet res2 = SqlLiteUtil.getInstance().query("select * from turno where fecha ='" + fecha + "' and id_profesional ='" + id_profesional + "'");
        int cant = getCantTurnos(res2);
        ResultSet res = SqlLiteUtil.getInstance().query("select * from turno where fecha ='" + fecha + "' and id_profesional ='" + id_profesional + "'");
        while (h_inicio < h_fin || fila < cant) {
            if (aux != 0) {
                if (aux == 60) {
                    hora = h_inicio + 1 + ":00";
                } else {
                    hora = h_inicio + ":" + aux;
                }
            } else {
                hora = h_inicio + ":00";
            }
            model.addRow(new Object[7]);
            model.setValueAt(hora, fila, HORA);
            try {
                if (res.next() && res.getString("nombre") != null && hora.equals(res.getString("hora"))) {
                    if (!"null".equals(res.getString("documento"))) {
                        model.setValueAt(res.getString("documento"), fila, DOC);
                    }
                    if (!"null".equals(res.getString("telefono"))) {
                        model.setValueAt(res.getString("telefono"), fila, TEL);
                    }
                    if (!"null".equals(res.getString("descripcion"))) {
                        model.setValueAt(res.getString("descripcion"), fila, DESCRIPCION);
                    }
                    if (!"null".equals(res.getString("nombre"))) {
                        model.setValueAt(res.getString("nombre"), fila, NOMBRE);
                    }
                    if (!"null".equals((res.getString("os")))) {
                        model.setValueAt(res.getString("os"), fila, OS);
                    }

                    if ("true".equals(res.getString("Asistencia"))) {
                        model.setValueAt(true, fila, ASISTENCIA);
                    } else {
                        model.setValueAt(false, fila, ASISTENCIA);
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
        SqlLiteUtil.getInstance().desconectar();
    }

    public String getIdProfesional(String nombre, String mail) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado;
        try {
            resultado = SqlLiteUtil.getInstance().query("select max(id_profesional) from profesional");
            String ret = resultado.getString(1);
            SqlLiteUtil.getInstance().desconectar();
            return ret;
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ResultSet getHorarios(String id_horario) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado = null;
        String sql = "select * from horario where id_horario = '" + id_horario + "'";
        resultado = SqlLiteUtil.getInstance().query(sql);
        SqlLiteUtil.getInstance().desconectar();
        return resultado;
    }

    public void eliminarProfesional(String id_profesional) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet res = null;
        String sql = "delete from profesional where id_profesional='" + id_profesional + "'";
        res = SqlLiteUtil.getInstance().query(sql);
        SqlLiteUtil.getInstance().desconectar();
    }

    public void eliminarHorario(String id_horario) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet res = null;
        String sql = "delete from horario where id_horario='" + id_horario + "'";
        res = SqlLiteUtil.getInstance().query(sql);
        SqlLiteUtil.getInstance().desconectar();
    }

    public boolean existeProfesional(String id_profesional) {
        SqlLiteUtil.getInstance().conectar();
        ResultSet resultado;

        String sql = "select * from profesional where id_profesional='" + id_profesional + "'";
        resultado = SqlLiteUtil.getInstance().query(sql);
        try {
            if (resultado.next()) {
                SqlLiteUtil.getInstance().desconectar();
                return true;
            } else {
                SqlLiteUtil.getInstance().desconectar();
                return false;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * Este metodo valida si el usuario es o no valido a traves de una
     * propertie.
     *
     * @param nombre
     * @param pass
     * @return
     */
    public boolean validarUsuario(String nombre, String pass) {
        return nombre.equals(SqlLiteUtil.getInstance().getUser()) && pass.equals(SqlLiteUtil.getInstance().getPass());
    }
}