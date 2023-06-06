package paquete02;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecProp {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietarios;
    private String nombreArchivo;

    public LecProp(String n) {
        nombreArchivo = n;
        File f = new File("datos/" + nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream("datos/" + nombreArchivo));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void setListaPropietarios() {
        
        propietarios = new ArrayList<>();
        File f = new File("datos/" + getNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
                    
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Propietario> getListaPropietarios() {
        return propietarios;
    }
    
        public Propietario getPropietraio(String id) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getIdentificacion()
                    .equals(id)) {
                return propietarios.get(i);
            }
        }
        return null;     
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "\nLista de Propietarios:\n\n";
        for (int i = 0; i < getListaPropietarios().size(); i++) {
            Propietario p = getListaPropietarios().get(i);
            cadena = String.format("%s----\nPropietario - %s\n"
                    + "Nombres: %s\n"
                    + "Apellidos: %s\n----\n", cadena,
                    p.getIdentificacion(),
                    p.getNombres(),
                    p.getApellidos());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}