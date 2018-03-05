package com.example.dss22.bdrecycler;

/**
 * Created by dss22 on 28/02/18.
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class BDHandler extends SQLiteOpenHelper {

    private static final String database = "DataBaseP.db";
    private SQLiteDatabase db;
    private final Context context;


    public BDHandler(Context context) {
        super(context, database, null, 1);
        db = getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Empleados (Clave INT PRIMARY KEY,Nombre VARCHAR(50),Apellido VARCHAR(50) ,Salario FLOAT )");
        sqLiteDatabase.execSQL("INSERT INTO  Empleados VALUES (1,'Dylan','Parra',50)");
        sqLiteDatabase.execSQL("INSERT INTO  Empleados VALUES (2,'Salvador','Dominguez',40)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Empleados");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Item> consulta() {
        ArrayList<Item> lista = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Empleados", null);
        while (c.moveToNext()) {
            lista.add(new Item(c.getString(0), c.getString(1), c.getString(2) ,c.getString(3) ));
        }
        c.close();
        return lista;
    }
}


