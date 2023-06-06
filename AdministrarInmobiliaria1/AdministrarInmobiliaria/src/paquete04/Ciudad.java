package paquete04;

import java.io.Serializable;

public class Ciudad implements Serializable{

    private String nombre;
    private String provincia;

    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        String m = String.format("\n----\nCiudad: %s\n"
                + "Provincia: %s\n----\n", nombre, provincia);

        return m;
    }
}