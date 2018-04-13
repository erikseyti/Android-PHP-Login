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
        EditText editCidade = (EditText)findViewById(R.id.editCidade);
        String usuarioNome = editNome.getText().toString();
        String usuarioCidade = editCidade.getText().toString();

        Toast.makeText(this,"Nome do Usuario: "+usuarioNome,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Cidade do Usuario: "+usuarioCidade,Toast.LENGTH_SHORT).show();
    }
}
