package com.example.dss22.a331servicioswebalumnos;

import android.os.AsyncTask;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class Post extends AsyncTask<URL, String, String> {
    ServerResponse server;
    String post;

    public Post(ServerResponse server) {
        this.server = server;
    }

    public void getJSON(String r) {
        post = r;
    }


    @Override
    protected String doInBackground(URL... urls) {
        String resp = "";
        HttpURLConnection conexion = null;
        try {

            conexion = (HttpURLConnection) urls[0].openConnection();
            conexion.setDoOutput(true);
            conexion.setDoInput(true);
            conexion.setFixedLengthStreamingMode(post.length());
            conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            OutputStream out = new BufferedOutputStream(conexion.getOutputStream());
            out.write(post.getBytes());
            out.flush();
            out.close();
            if (conexion.getResponseCode() == 200) {
                InputStreamReader inp = new InputStreamReader(conexion.getInputStream(), "UTF-8");
                BufferedReader input = new BufferedReader(inp);
                String a = "";
                do {
                    a = input.readLine();
                    if (a != null) {
                        a += a;
                    }
                } while (a != null);
                input.close();
            } else {
                resp = "Sin respuesta";
            }
        } catch (UnknownHostException e) {

            resp= "No se pudo tener acceso";

        } catch (IOException e) {

            resp = "Error lectura/escritura";

        } finally {

            if (conexion != null) {
                conexion.disconnect();
            }
        }

        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        server.procesarRespuesta(s);
    }
}
