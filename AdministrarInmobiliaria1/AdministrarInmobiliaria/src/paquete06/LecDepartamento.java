package paquete06;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivo;

    public LecDepartamento(String n) {
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

    public void setListaDepartamentos() {

        departamentos = new ArrayList<>();
        File f = new File("datos/" + getNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);

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

    public ArrayList<Departamento> getListaDepartamentos() {
        return departamentos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "\nLista de Departamentos:\n";
        for (int i = 0; i < getListaDepartamentos().size(); i++) {
            Departamento d = getListaDepartamentos().get(i);
            cadena = String.format(
                    "%s==============================================\n"
                    + "Propietario: %s %s\n"
                    + "Identificación: %s\n"
                    + "Precio por metro cuadrado: %.2f\n"
                    + "Nro. metros cuadrados: %.2f\n"
                    + "Alicuota mensual: %.2f\n"
                    + "Costo final: %.2f\n"
                    + "----------------------------\n"
                    + "\tNombre edificio: %s\n"
                    + "\tUbicación en edificio: %s\n"
                    + "\tConstructora: %s - ID empresa: %d\n"
                    + "\tCiudad: %s\n"
                    + "\tProvincia: %s\n"
                    + "\tBarrio: %s\n"
                    + "\tReferencia: %s\n"
                    + "==============================================\n\n",
                    cadena,
                    d.getPropietario().getNombres(),
                    d.getPropietario().getApellidos(),
                    d.getPropietario().getIdentificacion(),
                    d.getPrecioMetroCuadrado(),
                    d.getNroMetroCuadrado(),
                    d.getAlicuotaMensual(),
                    d.getCostoFinal(),
                    d.getNombreEdificio(),
                    d.getUbicacionEnEdificio(),
                    d.getConstructora().getNombreConstructora(),
                    d.getConstructora().getIdEmpresa(),
                    d.getCiudad().getNombre(),
                    d.getCiudad().getProvincia(),
                    d.getBarrio().getNombre(),
                    d.getBarrio().getReferencia());
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