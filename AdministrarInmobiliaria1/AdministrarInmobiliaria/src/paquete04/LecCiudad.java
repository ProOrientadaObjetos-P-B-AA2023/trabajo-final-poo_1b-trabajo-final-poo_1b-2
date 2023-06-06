package paquete04;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudades;
    private String nombreArchivo;

    public LecCiudad(String n) {
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

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCiudades() {
        
        ciudades = new ArrayList<>();
        File f = new File("datos/" + obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
                    
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

    public ArrayList<Ciudad> obtenerListaCiudades() {
        return ciudades;
    }
    
        public Ciudad obtenerCiudad(String nombreCiudad) {
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudades.get(i).getNombre()
                    .equals(nombreCiudad)) {
                return ciudades.get(i);
            }
        }
        return null;     
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "\nLista de Ciudades:\n\n";
        for (int i = 0; i < obtenerListaCiudades().size(); i++) {
            Ciudad c = obtenerListaCiudades().get(i);
            cadena = String.format("%s----\nCiudad %s\n"
                    + "Provincia: %s\n----\n", 
                    cadena,
                    c.getNombre(),
                    c.getProvincia());
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