package com.example.erik.conectorandroidphp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }

    public void CadastrarUsuario(View view) {
        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editRG = (EditText) findViewById(R.id.editRg);
        EditText editCpf = (EditText) findViewById(R.id.editCpf);
        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        EditText editTelefone = (EditText) findViewById(R.id.editTelefone);

        String usuarioNome = editNome.getText().toString();
        String usuarioRg = editRG.getText().toString();
        String usuarioCpf = editCpf.getText().toString();
        String usuarioEmail = editEmail.getText().toString();
        String usuarioTelefone = editTelefone.getText().toString();

        Toast.makeText(this, "Nome do Usuario: " + usuarioNome, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Cidade do Usuario: " + usuarioRg, Toast.LENGTH_SHORT).show();

        //Nesta linha será feito a conexão entre a aplicação em PHP e o Android
        //Para Salvar os dados
        passarDadosWebService(usuarioNome, usuarioRg, usuarioCpf, usuarioEmail, usuarioTelefone);

    }

    private void passarDadosWebService(String nome, String rg, String cpf, String email, String telefone) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //String myurl = "http://172.17.241.67:8081/ServicoWeb/resource/WebService/addAdocao";
        String myurl = "https://ifpr-pos-tcc.000webhostapp.com/api/index.php?controller=usuario&action=" +
                "insert&data[nome]="+nome+"&data[cpf]="+cpf+"&data[rg]="+rg+"&data[email]="+email+"$data[telefone]"+telefone;

        //https://ifpr-pos-tcc.000webhostapp.com/api/index.php?controller=usuario&action=insert&data[nome]=test&data[cpf]=123&data[rg]=10
        //String POST_PARAMS = "?controller=usuario&action=select&data[nome]=" + nome + "&data[rg]=" + rg + "&data[cpf]=" + cpf + "&data[email]=" + email + "&data[telefone]=" + telefone;
        //Toast.makeText(this,POST_PARAMS,Toast.LENGTH_SHORT).show();

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            Toast.makeText(this,url.toString(),Toast.LENGTH_SHORT).show();
            OutputStream os = conn.getOutputStream();
            //os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            conn.connect();
            int response = conn.getResponseCode();
            Log.i("MainActivity", "The response is: " + response);
            Toast.makeText(this,response,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
