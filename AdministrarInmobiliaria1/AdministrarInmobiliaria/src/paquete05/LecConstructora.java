package paquete05;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecConstructora {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructoras;
    private String nombreArchivo;

    public LecConstructora(String n) {
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

    public void setListaConstructoras() {
        
        constructoras = new ArrayList<>();
        File f = new File("datos/" + getNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructoras.add(registro);
                    
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

    public ArrayList<Constructora> getListaConstructoras() {
        return constructoras;
    }
    
    public Constructora getConstructora(int id) {
        for (int i = 0; i < constructoras.size(); i++) {
            if (constructoras.get(i).getIdEmpresa() == id) {
                return constructoras.get(i);
            }
        }
        return null;     
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "\nLista de Constructoras:\n\n";
        for (int i = 0; i < getListaConstructoras().size(); i++) {
            Constructora c = getListaConstructoras().get(i);
            cadena = String.format("%s----\nConstructora - %s\n"
                    + "ID empresa: %d\n----\n", cadena,
                    c.getNombreConstructora(),
                    c.getIdEmpresa());
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