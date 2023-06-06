package paquete05;

import java.io.Serializable;

public class Constructora implements Serializable{

    private String nombreConstructora;
    private int idEmpresa;

    public Constructora(String nombreConstructora, int idEmpresa) {
        this.nombreConstructora = nombreConstructora;
        this.idEmpresa = idEmpresa;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    

    @Override
    public String toString() {
        String m = String.format("\n----\nConstructora %s\n"
                + "ID Empresa: %d\n----\n", nombreConstructora,
                idEmpresa);
        return m;
    }
}