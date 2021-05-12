package com.example.praticaretrofit1.models;

public class Producto {

    private int idTransporte;
    private String nombre;
    private String costo;
    private idLugares idLugares;


    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public com.example.praticaretrofit1.models.idLugares getIdLugares() {
        return idLugares;
    }

    public void setIdLugares(com.example.praticaretrofit1.models.idLugares idLugares) {
        this.idLugares = idLugares;
    }
}
