package com.example.erik.conectorandroidphp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListaUsuario extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listViewUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        listViewUsuario = (ListView) findViewById(R.id.listUsuarios);
        BuscarLista buscarLista = new BuscarLista(ListaUsuario.this);
        buscarLista.execute("https://ifpr-pos-tcc.000webhostapp.com/api/index.php?controller=usuario&action=select&data[search]=","","");


        //lista simples de teste
        String usuarios[] = {"Erik","Leonardo","Fabio"};
        // criando um adapter simples para preencher a lista de usuarios
        // este adapter exibe uma lista de usuarios com apenas um dado por linha
        ArrayAdapter<String> adapterUsuario = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usuarios);

        //listViewUsuario.setAdapter(adapterUsuario);
        //List<Usuario> listaUsuario = new ArrayList<>();
        //Setado Valor Padrão de uma instancia na List View
        //listaUsuario.add(new Usuario(1L,"Erik","Paranavaí"));
        //AdapterUsuario adapter = new AdapterUsuario(this,listaUsuario);

        listViewUsuario.setAdapter(adapterUsuario);
        //listViewUsuario.getOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("MainActivity","Teste: "+adapterView.getItemAtPosition(i).toString());
        //Toast.makeText(this,"Nome do Usuario: "+adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
    }




}
