package com.example.dss22.a224proyectoapp;

/**
 * Created by lenovo on 07/03/2018.
 */

public class Alumno {

    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_ALUMNO = "Alumno";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "Nctrl";
    public static final String NOMBRE = "Nombre";
    public static final String TELEFONO = "Telefono";
    public static final String CARRERA = "Carrera";
    public static final String CORREO = "Correo";

    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_ALUMNO = "CREATE TABLE " + TABLE_ALUMNO + "("
            + ID + " INTEGER PRIMARY KEY,"
            + NOMBRE + " TEXT,"
            + TELEFONO + " TEXT,"
            + CARRERA + " TEXT,"
            + CORREO + " TEXT" + ")";


    /**
     * --------------------------------------------------------------------------- ACTIVIDAD
     * Define el nombre de la tabla
     */
    public static final String TABLE_ACTIVIDAD = "Actividad";


    /**
     * Define los campos de la tabla
     */
    public static final String IDC = "IDC";
    public static final String NOMBREA = "NombreA";
    public static final String CREDITOS = "Creditos";


    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_ACTIVIDAD = "CREATE TABLE " + TABLE_ACTIVIDAD + "("
            + IDC + " INTEGER PRIMARY KEY,"
            + NOMBREA + " TEXT,"
            + CREDITOS + " INTEGER" + ")";


    /**
     * ---------------------------------------------------------------------ENLACE
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */

    public static final String TABLE_ALAC = "ALAC";

    public static final String FECHA = "Fecha";
    public static final String NOMRE = "Nombre";
    public static final String CRED = "Creditos";

    public static final String CREATE_TABLE_ALAC = "CREATE TABLE " + TABLE_ALAC + "("
            + ID + " INTEGER,"
            + IDC + " INTEGER,"
            + NOMRE + " TEXT,"
            + CRED + " TEXT,"
            + FECHA + " TEXT," + "" +
            " FOREIGN KEY("+ID+") REFERENCES "+TABLE_ALUMNO+"("+ID+")   ," +
            " FOREIGN KEY("+IDC+") REFERENCES "+TABLE_ACTIVIDAD+"("+IDC+")            )";
}
