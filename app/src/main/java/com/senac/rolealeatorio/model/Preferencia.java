package com.senac.rolealeatorio.model;

import android.hardware.biometrics.BiometricManager;

public class Preferencia {
    String tipo;
    String nome;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isNomeEmptyOrNull(){
        return (nome == null || nome.isEmpty());
    }

    public boolean isTipoEmptyOrNull(){
        return (tipo == null || tipo.isEmpty());
    }
}
