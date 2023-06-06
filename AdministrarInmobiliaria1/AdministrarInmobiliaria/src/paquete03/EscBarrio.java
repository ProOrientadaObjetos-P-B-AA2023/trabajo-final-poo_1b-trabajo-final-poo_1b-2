package paquete03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscBarrio {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registro;
    private ArrayList<Barrio> lista;

    public EscBarrio(String nombreArc) {
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
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void setRegistro(Barrio b) {
        registro = b;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void setLista() {
        LecBarrio l = new LecBarrio(
                getNombreArchivo());
        l.setListaBarrios();
        lista = l.getListaBarrios();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Barrio> getLista() {
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
            System.err.println("Error al cerrar el archivo.");

        }
    }
}