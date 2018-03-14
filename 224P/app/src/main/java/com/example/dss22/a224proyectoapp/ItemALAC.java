package com.example.dss22.a224proyectoapp;

/**
 * Define la estructura de un objeto Item
 * Utilizado para captar los atributos de persona
 */

public class ItemALAC {

    private int id;
    private String nombre;
    private String telefono;
    private String carrera;
    private String correo;

    private int idc;
    private String nombrea;
    private int creditos;


    private String fecha;





    public ItemALAC(){}

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public int getIdc() {return idc;}

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNombrea() {
        return nombrea;
    }

    public void setNombrea(String nombrea) {
        this.nombrea = nombrea;
    }

    public int getCreditos(){ return creditos; }

    public void setCreditos(int creditos){ this.creditos = creditos; }


    public String getFecha(){ return fecha; }

    public void setFecha(String fecha){ this.fecha = fecha; }



}
