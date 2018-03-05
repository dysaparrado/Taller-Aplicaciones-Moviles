package com.example.dss22.bdrecycler;

/**
 * Created by dss22 on 28/02/18.
 */

public class Item {
    private String clave,nombre,apellido,salario;

    public Item(String clave, String nombre, String apellido , String salario) {
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario=salario;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSalario() {
        return salario;
    }


}