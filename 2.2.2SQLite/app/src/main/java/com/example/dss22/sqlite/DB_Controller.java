package com.example.dss22.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "PruebaBase.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Users(ID INTEGER PRIMARY KEY AUTOINCREMENT, USUARIO TEXT UNIQUE, PASSWORD TEXT); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users;");
        onCreate(sqLiteDatabase);
    }

    public void insertar_user(String USUARIO, String PASSWORD){
        ContentValues contentValues = new ContentValues();
        contentValues.put("USUARIO",USUARIO);
        contentValues.put("PASSWORD",PASSWORD);
        this.getWritableDatabase().insertOrThrow("Users","",contentValues);
    }

    public void borrar_user(String USUARIO){
        this.getWritableDatabase().delete("Users","USUARIO='"+USUARIO+"'",null);
    }

    public  void actualizar(String viejo_USUARIO, String nuevo_USUARIO){
        this.getWritableDatabase().execSQL("UPDATE Users SET USUARIO='"+nuevo_USUARIO+"' WHERE USUARIO='"+viejo_USUARIO+"'");
    }

    public  void show_users(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM Users",null);
        textView.setText("");
        while(cursor.moveToNext()){
            textView.append(cursor.getString(1)+" "+cursor.getString(2)+"\n");
        }
    }

}
