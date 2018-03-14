package com.example.dss22.a224proyectoapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static com.example.dss22.a224proyectoapp.R.layout.spinner_layaout_ejemplo;


public class Functions extends SQLiteOpenHelper {

    private static final String DB_NAME = "crud.db";
    private static final int DB_VERSION = 1;

    public Activity activity;

    private Alumno persona = new Alumno();

    public Functions(Context context) {

        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //execute table persona
        sqLiteDatabase.execSQL(persona.CREATE_TABLE_ALUMNO);
        sqLiteDatabase.execSQL(persona.CREATE_TABLE_ACTIVIDAD);
        sqLiteDatabase.execSQL(persona.CREATE_TABLE_ALAC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + persona.TABLE_ALUMNO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + persona.TABLE_ACTIVIDAD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + persona.TABLE_ALAC);
    }

    /**
     * Insertar nuevos registros
     */
    public void InsertAl(Item item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.ID,item.getId());
        contentValues.put(persona.NOMBRE,item.getNombre());
        contentValues.put(persona.TELEFONO,item.getTelefono());
        contentValues.put(persona.CARRERA,item.getCarrera());
        contentValues.put(persona.CORREO,item.getCorreo());

        database.insert(persona.TABLE_ALUMNO,null,contentValues);
    }

    public void InsertAC(ItemAc item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.IDC,item.getIdc());
        contentValues.put(persona.NOMBREA,item.getNombrea());
        contentValues.put(persona.CREDITOS,item.getCreditos());


        database.insert(persona.TABLE_ACTIVIDAD,null,contentValues);
    }

    public void InsertALAC(ItemALAC item){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.ID,item.getId());
        contentValues.put(persona.IDC,item.getIdc());
        contentValues.put(persona.NOMRE,item.getNombrea());
        contentValues.put(persona.CRED,item.getCreditos());
        contentValues.put(persona.FECHA,item.getFecha());


        database.insert(persona.TABLE_ALAC,null,contentValues);
    }

    /**
     * Retorna un ArrayList con elementos de tipo item
     * Convierte el Cursor en un ArrayList
     */
    public ArrayList<Item> getAllRecordsAL(){

        ArrayList<Item>list = new ArrayList<Item>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ALUMNO +" ORDER BY Nombre ASC";

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setNombre(cursor.getString(1));
                item.setTelefono(cursor.getString(2));
                item.setCarrera(cursor.getString(3));
                item.setCorreo(cursor.getString(4));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }

    public ArrayList<ItemAc> getAllRecordsAC(){

        ArrayList<ItemAc>list = new ArrayList<ItemAc>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ACTIVIDAD +" ORDER BY IDC ASC";

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                ItemAc item = new ItemAc();
                item.setIdc(Integer.parseInt(cursor.getString(0)));
                item.setNombrea(cursor.getString(1));
                item.setCreditos(Integer.parseInt(cursor.getString(2)));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }

    public ArrayList<Item> getAllRecordsALAC(){

        ArrayList<Item>list = new ArrayList<Item>();
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ALAC;

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(1)));
                item.setIdc(Integer.parseInt(cursor.getString(1)));
                item.setFecha(cursor.getString(2));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }

    public ArrayList<ItemALAC> getAcALAC(int id){

        ArrayList<ItemALAC>list = new ArrayList<ItemALAC>();
     //   ItemALAC list2 = getItemAC(id);
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ALAC+" WHERE "+ persona.ID + "=?"+ " ORDER BY Fecha ASC";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()){
            do {
                ItemALAC item = new ItemALAC();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setIdc(Integer.parseInt(cursor.getString(1)));
                item.setNombrea(cursor.getString(2));
                item.setCreditos(Integer.parseInt(cursor.getString(3)));
                item.setFecha(cursor.getString(4));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }


    public ArrayAdapter<Spinner> llenarSpinner(Context cont){

        ArrayList<ItemAc> list = new ArrayList<>();
        ArrayList<Spinner> list2 = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ACTIVIDAD +" ORDER BY IDC ASC";

        Cursor cursor = database.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                ItemAc item = new ItemAc();
                Spinner item2 =new Spinner();
                item.setIdc(Integer.parseInt(cursor.getString(0)));
                item.setNombrea(cursor.getString(1));
                item.setCreditos(Integer.parseInt(cursor.getString(2)));
                list.add(item);

                item2.setId(Integer.parseInt(cursor.getString(0)));
                item2.setNombre(cursor.getString(1));
                item2.setCreditos(Integer.parseInt(cursor.getString(2)));
                list2.add(item2);

            }while (cursor.moveToNext());
        }





        ArrayAdapter<Spinner> adapter =
                new ArrayAdapter<Spinner>(cont, spinner_layaout_ejemplo,list2);
        adapter.setDropDownViewResource(spinner_layaout_ejemplo);

        cursor.close();
        database.close();

        return adapter;
    }


    /**
     * Obtiene un registro en específico
     */
    public Item getSingleItemAL(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ALUMNO + " WHERE " + persona.ID + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setNombre(cursor.getString(1));
        item.setTelefono(cursor.getString(2));
        item.setCarrera(cursor.getString(3));
        item.setCorreo(cursor.getString(4));

        cursor.close();
        database.close();
        return item;
    }

    public ItemAc getSingleItemAC(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ACTIVIDAD + " WHERE " + persona.IDC + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        ItemAc item = new ItemAc();
        item.setIdc(Integer.parseInt(cursor.getString(0)));
        item.setNombrea(cursor.getString(1));
        item.setCreditos(Integer.parseInt(cursor.getString(2)));


        cursor.close();
        database.close();
        return item;
    }

    public ItemAc getCreditos(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT IDC,Creditos FROM " + persona.TABLE_ACTIVIDAD + " WHERE " + persona.IDC + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        ItemAc item = new ItemAc();


       // item.setIdc(cursor.getInt(0));
        item.setCreditos(cursor.getInt(1));



        cursor.close();
        database.close();
        return item;
    }



    public Item getSingleItemALAC(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ALAC + " WHERE " + persona.IDC  +"=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setIdc(Integer.parseInt(cursor.getString(1)));
        item.setFecha(String.valueOf(Integer.parseInt(cursor.getString(2))));


        cursor.close();
        database.close();
        return item;
    }



    public ItemALAC getSingleALAC(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT * FROM " + persona.TABLE_ALAC + " WHERE " + persona.IDC  +"=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToNext();

        ItemALAC item = new ItemALAC();
        item.setId(Integer.parseInt(cursor.getString(0)));
        item.setIdc(Integer.parseInt(cursor.getString(1)));
        item.setNombrea(cursor.getString(2));
        item.setCreditos(Integer.parseInt(cursor.getString(3)));
        item.setFecha(cursor.getString(4));


        cursor.close();
        database.close();
        return item;
    }

    public ItemALAC getItemAC(int id){

        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT ALAC.IDC,Fecha,NombreA FROM " + persona.TABLE_ALAC  +
                " INNER JOIN Actividad ON Actividad.IDC = ALAC.IDC "+ " WHERE ALAC." + persona.IDC + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor != null && cursor.moveToFirst())
            cursor.moveToNext();

        ItemALAC item = new ItemALAC();
        assert cursor != null;
        item.setIdc(Integer.parseInt(cursor.getString(0)));
        item.setFecha(cursor.getString(1));
        item.setNombrea(cursor.getString(2));



        cursor.close();
        database.close();
        return item;
    }

    public ArrayList<ItemALAC> getR(int id){

        ArrayList<ItemALAC>list = new ArrayList<ItemALAC>();
        //   ItemALAC list2 = getItemAC(id);
        SQLiteDatabase database = getReadableDatabase();

        String sql = "SELECT Fecha,NombreA FROM " + persona.TABLE_ALAC  +
                " INNER JOIN Actividad ON Actividad.IDC = ALAC.IDC "+ " WHERE ALAC." + persona.IDC + "=?";
        Cursor cursor = database.rawQuery(sql,new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()){
            do {
                ItemALAC item = new ItemALAC();
                item.setFecha(cursor.getString(0));
                item.setNombrea(cursor.getString(1));

                list.add(item);

            }while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return list;
    }

    /**
     * Borra un elemento de la tabla
     */
    public void DeleteItem(int id){

        SQLiteDatabase database = getWritableDatabase();
        database.delete(persona.TABLE_ALUMNO, persona.ID + "=?",new String[]{String.valueOf(id)});
        database.close();
    }

    /**
     *Actualiza un registro
     */
    public void UpdateAL(Item item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.NOMBRE,item.getNombre());
        contentValues.put(persona.TELEFONO,item.getTelefono());
        contentValues.put(persona.CARRERA,item.getCarrera());
        contentValues.put(persona.CORREO,item.getCorreo());
        database.update(persona.TABLE_ALUMNO,contentValues, persona.ID + "=?",new String[]{String.valueOf(item.getId())});

    }

    public void UpdateALC(Item item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.NOMBRE,item.getNombre());
        contentValues.put(persona.TELEFONO,item.getTelefono());
        contentValues.put(persona.CARRERA,item.getCarrera());
        contentValues.put(persona.CORREO,item.getCorreo());
        database.update(persona.TABLE_ALUMNO,contentValues, persona.ID + "=?",new String[]{String.valueOf(item.getId())});

    }

    public void UpdateAC(ItemAc item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.NOMBREA,item.getNombrea());
        contentValues.put(persona.CREDITOS,item.getCreditos());
        database.update(persona.TABLE_ACTIVIDAD,contentValues, persona.IDC + "=?",new String[]{String.valueOf(item.getIdc())});

    }

    public void UpdateALAC(ItemALAC item){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(persona.NOMRE,item.getNombrea());
        contentValues.put(persona.CRED,item.getCreditos());
        contentValues.put(persona.FECHA,item.getFecha());
        database.update(persona.TABLE_ALAC,contentValues, persona.ID + "=?",new String[]{String.valueOf(item.getId())});

    }

    /**
     * Responde a la opción del menu de borrar todo
     */
    public void DeleteAll(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(persona.TABLE_ALAC,null,null);
        database.delete(persona.TABLE_ALUMNO,null,null);
        database.delete(persona.TABLE_ACTIVIDAD,null,null);
        database.close();
    }

}
