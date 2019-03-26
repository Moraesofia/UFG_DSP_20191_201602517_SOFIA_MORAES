package br.com.Moraesofia.dsp20191.aulas0508.ap;

public class Usuario {

    private String nome;

    private String login;

    private String senha;

    public Usuario(String nome, String login, String senha) {
        super();
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String atributesToString() {
        StringBuilder at = new StringBuilder();
        at.append("Nome: " + this.nome + "\n");
        at.append("Login: " + this.login + "\n");
        at.append("Senha: " + this.senha + "\n");

        return at.toString();

    }

}
