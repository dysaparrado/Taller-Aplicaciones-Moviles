package com.example.dss22.a32serviciowebtipocambio;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    Button clima;
    TextView datos, datojson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clima = (Button)findViewById(R.id.ver);
        datos = (TextView)findViewById(R.id.datos_clima);
        datojson = (TextView)findViewById(R.id.info);

        clima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new OpenWeatherMapTask(
                        "Tepic",
                        datos).execute();
            }
        });
    }

    private class OpenWeatherMapTask extends AsyncTask<Void, Void, String> {

        String ciudad;
        TextView texto;

        String apikey = "825270067d97441685357d089ef4782d";
        String linkclima = "https://openexchangerates.org/api/latest.json?app_id="+apikey;

        OpenWeatherMapTask(String cityName, TextView tvResult){
            this.ciudad = cityName;
            this.texto = tvResult;
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = "";
            String queryReturn;

            String query = null;
            try {
                query = linkclima;
                queryReturn = sendQuery(query);
                result += ParseJSON(queryReturn);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                queryReturn = e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                queryReturn = e.getMessage();
            }


            final String finalQueryReturn = query + "\n\n" + queryReturn;


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    datojson.setText(finalQueryReturn);
                }
            });


            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            texto.setText(s);
        }

        private String sendQuery(String query) throws IOException {
            String result = "";

            URL searchURL = new URL(query);

            HttpURLConnection httpURLConnection = (HttpURLConnection)searchURL.openConnection();
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(
                        inputStreamReader,
                        8192);

                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }

                bufferedReader.close();
            }

            return result;
        }

        private String ParseJSON(String json){
            String jsonResult = "";

            try {
                JSONObject JsonObject = new JSONObject(json);
                String cod = jsonHelperGetString(JsonObject, "base");

                if(cod != null){
                    if(cod.equals("USD")){

                        String origen = jsonHelperGetString(JsonObject, "base");
                        jsonResult += "Moneda: "+origen+"\n";
                        jsonResult+="Tasa de Cambio:"+"\n"+"\n";

                        JSONObject usd = jsonHelperGetJSONObject(JsonObject, "rates");
                        if(usd!= null){
                            String peso = jsonHelperGetString(usd, "MXN");
                            jsonResult += "Peso Mexicano: "+peso+"\n";

                            String par = jsonHelperGetString(usd, "ARS");
                            jsonResult += "Peso Argentino: "+par+"\n";

                            String clp = jsonHelperGetString(usd, "CLP");
                            jsonResult += "Peso Chileno: "+clp+"\n";

                            String cop = jsonHelperGetString(usd, "COP");
                            jsonResult += "Peso Colombiano: "+cop+"\n";

                            String uyu = jsonHelperGetString(usd, "UYU");
                            jsonResult += "Peso Uruguayo: "+uyu+"\n";

                            String dop = jsonHelperGetString(usd, "DOP");
                            jsonResult += "Peso Dominicano: "+dop+"\n";

                            String cup = jsonHelperGetString(usd, "CUP");
                            jsonResult += "Peso Cubano: "+cup+"\n";

                            String euro = jsonHelperGetString(usd, "EUR");
                            jsonResult += "Euro: "+euro+"\n";

                            String gbp = jsonHelperGetString(usd, "GBP");
                            jsonResult += "Libra Esterlina: "+gbp+"\n";

                            String dcad = jsonHelperGetString(usd, "CAD");
                            jsonResult += "Dolar Canadiense: "+dcad+"\n";

                            String daud = jsonHelperGetString(usd, "AUD");
                            jsonResult += "Dolar Australiano: "+daud+"\n";

                            String nzd = jsonHelperGetString(usd, "NZD");
                            jsonResult += "Dolar Neozelandés: "+nzd+"\n";

                            String btc = jsonHelperGetString(usd, "BTC");
                            jsonResult += "Bitcoin: "+btc+"\n";

                            String inr = jsonHelperGetString(usd, "INR");
                            jsonResult += "Rupia India: "+inr+"\n";

                            String jpy = jsonHelperGetString(usd, "JPY");
                            jsonResult += "Yen Japones: "+jpy+"\n";

                            String cny = jsonHelperGetString(usd, "CNY");
                            jsonResult += "Yuan Chino: "+cny+"\n";

                            String kpw = jsonHelperGetString(usd, "KPW");
                            jsonResult += "Won Norcoreano: "+kpw+"\n";

                            String krw = jsonHelperGetString(usd, "KRW");
                            jsonResult += "Won Surcoreano: "+krw+"\n";







                        }







                    }else if(cod.equals("404")){
                        String message = jsonHelperGetString(JsonObject, "message");
                        jsonResult += "cod 404: " + message;
                    }
                }else{
                    jsonResult += "cod == null\n";
                }

            } catch (JSONException e) {
                e.printStackTrace();
                jsonResult += e.getMessage();
            }

            return jsonResult;
        }

        private String jsonHelperGetString(JSONObject obj, String k){
            String v = null;
            try {
                v = obj.getString(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return v;
        }

        private JSONObject jsonHelperGetJSONObject(JSONObject obj, String k){
            JSONObject o = null;

            try {
                o = obj.getJSONObject(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return o;
        }

        private JSONArray jsonHelperGetJSONArray(JSONObject obj, String k){
            JSONArray a = null;

            try {
                a = obj.getJSONArray(k);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return a;
        }
    }
}