package com.example.erik.conectorandroidphp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }
    public void CadastrarUsuario(View view)
    {
        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editRG = (EditText)findViewById(R.id.editRg);
        String usuarioNome = editNome.getText().toString();
        String usuarioRg = editRG.getText().toString();

        Toast.makeText(this,"Nome do Usuario: "+usuarioNome,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Cidade do Usuario: "+usuarioRg,Toast.LENGTH_SHORT).show();

        //Nesta linha será feito a conexão entre a aplicação em PHP e o Android
        //Para Salvar os dados
     }
}
