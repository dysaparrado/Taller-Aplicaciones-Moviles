package com.ejemplo.mydb03;

/**
 * Created by oscar on 27/02/18.
 */

public class Item {
    private String id,nombre,sueldo;

    public Item(String id, String nombre, String sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo=sueldo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSueldo() {
        return sueldo;
    }
}
