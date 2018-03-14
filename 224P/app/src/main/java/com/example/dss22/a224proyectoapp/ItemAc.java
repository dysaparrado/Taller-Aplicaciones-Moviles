package com.example.dss22.a224proyectoapp;

/**
 * Define la estructura de un objeto Item
 * Utilizado para captar los atributos de persona
 */

public class ItemAc {

    private int id;
    private String nombre;
    private String telefono;
    private String carrera;
    private String correo;

    private int idc;
    private String nombrea;
    private int creditos;


    private String fecha;





    public ItemAc(){}

    public ItemAc(int idc,String nombrea, int creditos){
        this.idc=idc;
        this.nombrea=nombrea;
        this.creditos=creditos;
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




}
