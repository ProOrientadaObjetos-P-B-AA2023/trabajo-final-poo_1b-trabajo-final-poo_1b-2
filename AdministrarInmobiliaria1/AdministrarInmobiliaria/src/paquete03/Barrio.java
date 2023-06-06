package paquete03;

import java.io.Serializable;

public class Barrio implements Serializable{
    private String nombre;
    private String referencia;

    public Barrio(String nombre, String referencia) {
        this.nombre = nombre;
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        String m = String.format("\n----\nBarrio: %s\n"
                + "Referencia: %s\n----\n", nombre, referencia);
        
        return m;
    }   
}