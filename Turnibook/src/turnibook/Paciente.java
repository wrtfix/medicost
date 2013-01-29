/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnibook;

/**
 *
 * @author wrtfix
 */
public class Paciente {
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String telefono;
    private Operaciones op;
    public Paciente(String nombre, String apellido, int edad, String direccion, String telefono, Operaciones op) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.op = op;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
