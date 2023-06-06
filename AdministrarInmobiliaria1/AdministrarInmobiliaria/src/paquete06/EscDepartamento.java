package paquete06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscDepartamento {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> lista;

    public EscDepartamento(String nombreArc) {
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

    public void setRegistro(Departamento d) {
        registro = d;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setLista() {
        LecDepartamento l = new LecDepartamento(
                getNombreArchivo());
        l.setListaDepartamentos();
        lista = l.getListaDepartamentos();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Departamento> getLista() {
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