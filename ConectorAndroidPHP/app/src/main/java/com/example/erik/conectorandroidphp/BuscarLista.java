package com.example.erik.conectorandroidphp;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aluno on 16/04/18.
 */

public class BuscarLista extends AsyncTask<String,Integer,String> {
    Activity activity;

    public BuscarLista(ListaUsuario listaUsuario) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {

            try {
                String myurl = "https://ifpr-pos-tcc.000webhostapp.com/api/index.php?controller=usuario&action=select&data[search]=";
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //conn.setReadTimeout(10000 /* milliseconds */);
                //conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                //conn.setDoInput(true);
                //Toast.makeText(this, url.toString(), Toast.LENGTH_SHORT).show();
                //OutputStream os = conn.getOutputStream();
                //os.flush();
                //os.close();

                conn.connect();


                int response = conn.getResponseCode();
                Log.i("MainActivity", "The response is: " + response);
                //Toast.makeText(this, response, Toast.LENGTH_SHORT).show();



                InputStream inputStream = conn.getInputStream();
                if (inputStream == null) {
                    return null;
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String linha;
                StringBuffer buffer = new StringBuffer();
                while ((linha = reader.readLine()) != null) {
                    buffer.append(linha + "\n");
                }

                if (buffer.length() == 0) {
                    return null;
                }

                if (conn != null) {
                    conn.disconnect();
                }

                if (reader != null) {

                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Erro", "Erro fechando o stream", e);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.i("MainActivity", "Erro!");
            }
            return "";
        }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
