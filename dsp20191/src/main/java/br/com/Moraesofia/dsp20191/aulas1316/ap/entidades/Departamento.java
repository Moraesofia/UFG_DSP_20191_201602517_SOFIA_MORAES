package br.com.Moraesofia.dsp20191.aulas1316.ap.entidades;

public class Departamento {

    private Long id;

    private String nome;

    public Departamento(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Departamento() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
