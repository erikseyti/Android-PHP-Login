package com.example.erik.conectorandroidphp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterUsuario extends BaseAdapter {

    Context contexto;
    List<Usuario> usuarios;

    public AdapterUsuario(Context contexto, List<Usuario> usuarios) {
        this.contexto = contexto;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return usuarios.get(i).getId();
    }

    //i = Position
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_lista_usuarios,viewGroup,false);
        TextView nome = (TextView) viewLinha.findViewById(R.id.textViewNome);
        TextView cidade = (TextView) viewLinha.findViewById(R.id.textViewCidade);
        Usuario usuario = usuarios.get(i);
        nome.setText(usuario.getNome());
        cidade.setText(usuario.getCidade());

        return viewLinha;
    }
}
