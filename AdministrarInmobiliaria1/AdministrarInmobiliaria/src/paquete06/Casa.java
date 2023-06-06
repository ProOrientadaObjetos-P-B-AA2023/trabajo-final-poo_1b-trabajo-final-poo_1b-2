package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Casa implements Serializable{

    private Propietario propietario;
    private double precioMetroCuadrado;
    private double nroMetroCuadrado;
    private int nroCuartos;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;

    public Casa(Propietario propietario, double precioMetroCuadrado, double nroMetroCuadrado, int nroCuartos, Barrio barrio, Ciudad ciudad, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.nroMetroCuadrado = nroMetroCuadrado;
        this.nroCuartos = nroCuartos;
        this.barrio = barrio;
        this.ciudad = ciudad;
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

    public int getNroCuartos() {
        return nroCuartos;
    }

    public void setNroCuartos(int nroCuartos) {
        this.nroCuartos = nroCuartos;
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

    public Constructora getConstructora() {
        return constructora;
    }

    public void setConstructora(Constructora constructora) {
        this.constructora = constructora;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void calcularCostoFinal() {
        costoFinal = (nroMetroCuadrado * precioMetroCuadrado);
    }
}