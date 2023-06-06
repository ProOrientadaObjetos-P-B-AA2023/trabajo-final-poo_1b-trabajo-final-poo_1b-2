package paquete06;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;

    public LecCasa(String n) {
        nombreArchivo = n;
        File f = new File("datos/" + nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream("datos/" + nombreArchivo));
            } catch (IOException ioException) {
                System.err.println(ioException.getMessage());

            }
        }
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void setListaCasas() {

        casas = new ArrayList<>();
        File f = new File("datos/" + getNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);

                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: "
                            + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: "
                            + ex.getMessage());
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Casa> getListaCasas() {
        return casas;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "\nLista de Casas:\n";
        for (int i = 0; i < getListaCasas().size(); i++) {
            Casa c = getListaCasas().get(i);
            cadena = String.format(
                    "%s==============================================\n"
                    + "Propietario: %s %s\n"
                    + "Identificación: %s\n"
                    + "Precio por metro cuadrado: %.2f\n"
                    + "Nro. metros cuadrados: %.2f\n"
                    + "Nro. cuartos: %d\n"
                    + "Costo final: %.2f\n"
                    + "----------------------------\n"
                    + "\tConstructora: %s - ID empresa: %d\n"
                    + "\tCiudad: %s\n"
                    + "\tProvincia: %s\n"
                    + "\tBarrio: %s\n"
                    + "\tReferencia: %s\n"
                    + "==============================================\n\n",
                    cadena,
                    c.getPropietario().getNombres(),
                    c.getPropietario().getApellidos(),
                    c.getPropietario().getIdentificacion(),
                    c.getPrecioMetroCuadrado(),
                    c.getNroMetroCuadrado(),
                    c.getNroCuartos(),
                    c.getCostoFinal(),
                    c.getConstructora().getNombreConstructora(),
                    c.getConstructora().getIdEmpresa(),
                    c.getCiudad().getNombre(),
                    c.getCiudad().getProvincia(),
                    c.getBarrio().getNombre(),
                    c.getBarrio().getReferencia());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
            System.exit(1);
        }
    }
}