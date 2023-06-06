package paquete04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscCiudad {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ciudad registro;
    private ArrayList<Ciudad> lista;

    public EscCiudad(String nombreArc) {
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

    public void setrNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void setRegistro(Ciudad c) {
        registro = c;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void setLista() {
        LecCiudad l = new LecCiudad(
                getNombreArchivo());
        l.setListaCiudades();
        lista = l.getListaCiudades();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ciudad> getLista() {
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