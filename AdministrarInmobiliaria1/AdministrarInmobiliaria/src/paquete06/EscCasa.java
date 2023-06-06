package paquete06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscCasa {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registro;
    private ArrayList<Casa> lista;

    public EscCasa(String nombreArc) {
        nombreArchivo = nombreArc;
        setLista();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream("datos/" + nombreArchivo));

            if (getLista().size() > 0) {
                for (int i = 0; i < getLista().size(); i++) {
                    setRegistro(getLista().get(i));
                    setSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void setRegistro(Casa c) {
        registro = c;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setLista() {
        LecCasa l = new LecCasa(
                getNombreArchivo());
        l.setListaCasas();
        lista = l.getListaCasas();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Casa> getLista() {
        return lista;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());

        }
    }
}