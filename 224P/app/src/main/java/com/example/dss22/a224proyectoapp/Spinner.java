package com.example.dss22.a224proyectoapp;

/**
 * Created by diego.lira on 29/04/2017.
 */

public class Spinner {
    int id;
    String nombre;
    int creditos;

    public Spinner(int id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos=creditos;
    }

    public Spinner() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
