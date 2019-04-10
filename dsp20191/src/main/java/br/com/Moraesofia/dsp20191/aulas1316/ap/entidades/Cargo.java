package br.com.Moraesofia.dsp20191.aulas1316.ap.entidades;

public class Cargo {

    private Long id;

    private String nome;

    private Double salario;

    public Cargo(Long id, String nome, Double salario) {
        super();
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }

}
