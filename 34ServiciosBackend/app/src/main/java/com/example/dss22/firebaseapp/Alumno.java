package com.example.dss22.firebaseapp;

public class Alumno {
    String nombre;
    String nocontrol;

    public Alumno(String nombre, String nocontrol) {
        this.nombre = nombre;
        this.nocontrol = nocontrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }
}
