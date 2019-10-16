package com.example.tachosprojectv2.Model;

public class ModeloControl {

    String nombre, ocupado, tipoReg;
    int espacio, ordLlegada;

    public String getOcupado() {
        return ocupado;
    }

    public void setOcupado(String ocupado) {
        this.ocupado = ocupado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public void setTipoReg(String tipoReg) {
        this.tipoReg = tipoReg;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public int getOrdLlegada() {
        return ordLlegada;
    }

    public void setOrdLlegada(int ordLlegada) {
        this.ordLlegada = ordLlegada;
    }
}
