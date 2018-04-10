package com.example.dss22.a331servicioswebalumnos;

import android.content.Context;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

public class GetID extends AsyncTask<Void, Void, Void> {

    ArrayList<Item> list;
    Adapter adapter;
    Context context;
    String data = "";
    int id;

    public GetID(int id, Context context) {
        this.id = id;
        this.context=context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {

            list = new ArrayList<>();
            URL url = new URL("http://dsparra22.x10host.com/datos1/obtener_alumno_por_id.php?idalumno=" + id);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }

            JSONObject JO = new JSONObject(data);
            JSONObject alumnos = JO.getJSONObject("alumno");
            list.add(new Item(alumnos.get("idAlumno").toString(),
                    URLDecoder.decode(alumnos.get("nombre").toString(),"UTF-8"),
                    URLDecoder.decode(alumnos.get("direccion").toString(),"UTF-8")));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        adapter = new Adapter(list,context);
        MainActivity.recycler.setAdapter(adapter);
    }
}
