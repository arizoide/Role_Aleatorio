package com.senac.rolealeatorio.model;

import android.text.TextUtils;

import java.util.Date;

public class Usuario {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Date dataNascimento;
    private String CPF;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean isCPFNullOrEmpty(){
        return (CPF == null || CPF.isEmpty());
    }

    public boolean isSenhaNullOrEmpty(){
        return (senha == null || senha.isEmpty());
    }

    public boolean isEmailNullOrEmpty(){
        return (email == null || email.isEmpty());
    }

    //Alt + Insert
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
