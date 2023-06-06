package paquete03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecBarrio {

    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrios;
    private String nombreArchivo;

    public LecBarrio(String n) {
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

    public void setListaBarrios() {
        
        barrios = new ArrayList<>();
        File f = new File("datos/" + getNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrios.add(registro);
                    
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

    public ArrayList<Barrio> getListaBarrios() {
        return barrios;
    }
    
        public Barrio getBarrio(String nombreBarrio) {
        for (int i = 0; i < barrios.size(); i++) {
            if (barrios.get(i).getNombre()
                    .equals(nombreBarrio)) {
                return barrios.get(i);
            }
        }
        return null;     
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "\nLista de Barrios:\n\n";
        for (int i = 0; i < getListaBarrios().size(); i++) {
            Barrio b = getListaBarrios().get(i);
            cadena = String.format("%s----\nBarrio %s\n"
                    + "Referencia: %s\n----\n", 
                    cadena,
                    b.getNombre(),
                    b.getReferencia());
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