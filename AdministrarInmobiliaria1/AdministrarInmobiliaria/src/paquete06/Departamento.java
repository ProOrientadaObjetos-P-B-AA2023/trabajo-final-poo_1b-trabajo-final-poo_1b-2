package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Departamento implements Serializable{
    
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double nroMetroCuadrado;
    private double alicuotaMensual;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionEnEdificio;
    private Constructora constructora;

    public Departamento(Propietario propietario, double precioMetroCuadrado, double nroMetroCuadrado, double alicuotaMensual, double costoFinal, Barrio barrio, Ciudad ciudad, String nombreEdificio, String ubicacionEnEdificio, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.nroMetroCuadrado = nroMetroCuadrado;
        this.alicuotaMensual = alicuotaMensual;
        this.costoFinal = costoFinal;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionEnEdificio = ubicacionEnEdificio;
        this.constructora = constructora;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public double getNroMetroCuadrado() {
        return nroMetroCuadrado;
    }

    public void setNroMetroCuadrado(double nroMetroCuadrado) {
        this.nroMetroCuadrado = nroMetroCuadrado;
    }

    public double getAlicuotaMensual() {
        return alicuotaMensual;
    }

    public void setAlicuotaMensual(double alicuotaMensual) {
        this.alicuotaMensual = alicuotaMensual;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getUbicacionEnEdificio() {
        return ubicacionEnEdificio;
    }

    public void setUbicacionEnEdificio(String ubicacionEnEdificio) {
        this.ubicacionEnEdificio = ubicacionEnEdificio;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    public void setConstructora(Constructora constructora) {
        this.constructora = constructora;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public void calcularCostoFinal() {
        costoFinal = (nroMetroCuadrado * precioMetroCuadrado) 
                + (alicuotaMensual * 12);
    }
}