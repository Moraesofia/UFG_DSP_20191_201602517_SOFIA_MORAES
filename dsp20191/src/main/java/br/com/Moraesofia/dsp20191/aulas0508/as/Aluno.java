package br.com.Moraesofia.dsp20191.aulas0508.as;

public class Aluno {

    private String nome;

    private Long matricula;

    private Double nota1;

    private Double nota2;

    public Aluno(String nome, Long matricula, Double nota1, Double nota2) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public Double getNota1() {
        return nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

}
