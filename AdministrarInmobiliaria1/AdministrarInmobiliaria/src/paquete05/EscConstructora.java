package paquete05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscConstructora {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registro;
    private ArrayList<Constructora> lista;

    public EscConstructora(String nombreArc) {
        nombreArchivo = nombreArc;
        setLista();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream("datos/"+ nombreArchivo));

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

    public void setRegistro(Constructora c) {
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
        LecConstructora l = new LecConstructora(
                getNombreArchivo());
        l.setListaConstructoras();
        lista = l.getListaConstructoras();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> getLista() {
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