package paquete02;

import java.io.Serializable;

public class Propietario implements Serializable{
    private String nombres;
    private String apellidos;
    private String identificacion;

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    @Override
    public String toString() {
        String m = String.format("\n----\nPropietario %s %s\n"
                + "Identificación: %s\n----\n", nombres, apellidos, 
                identificacion);
        return m;
    }
}