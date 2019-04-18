package br.com.Moraesofia.dsp20191.aulas1316.ap.entidades;

public class Funcionario {

    private Long id;

    private String nome;

    private Long matricula;

    public Funcionario(Long id, String nome, Long matricula) {
        super();
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

}
