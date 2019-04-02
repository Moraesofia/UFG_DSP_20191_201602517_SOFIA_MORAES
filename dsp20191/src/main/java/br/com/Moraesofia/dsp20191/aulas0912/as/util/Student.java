package br.com.Moraesofia.dsp20191.aulas0912.as.util;

import java.util.ArrayList;

public class Student {

    private String matricula;

    private String firstname;

    private String lastname;

    private String nickname;

    private ArrayList<Aulas> frequencia;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<Aulas> getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(ArrayList<Aulas> frequencia) {
        this.frequencia = frequencia;
    }

}
