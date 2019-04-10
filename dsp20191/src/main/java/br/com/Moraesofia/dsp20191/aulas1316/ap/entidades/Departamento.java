package br.com.Moraesofia.dsp20191.aulas1316.ap.entidades;

public class Departamento {

    private Long id;

    private String nome;

    public Departamento(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
