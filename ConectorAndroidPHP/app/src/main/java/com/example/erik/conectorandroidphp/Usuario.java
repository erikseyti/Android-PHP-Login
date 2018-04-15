package com.example.erik.conectorandroidphp;

import java.util.Date;

public class Usuario {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String celular;


    public Usuario() {
    }

    public Usuario(Long id, String nome, String rg) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
    }

    public Usuario(Long id, String nome, String cpf, String rg, Date dataNascimento, String email, String telefone, String celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
