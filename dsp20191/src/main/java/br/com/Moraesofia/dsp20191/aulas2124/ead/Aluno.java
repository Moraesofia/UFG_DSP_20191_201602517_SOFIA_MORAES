package br.com.Moraesofia.dsp20191.aulas2124.ead;

public class Aluno {

    private String nome;

    private Long matricula;

    private String disciplina;

    private Double nota1;

    private Double nota2;

    private int MEDIA = 6;

    public Aluno(String nome, Long matricula, String disciplina, Double nota1, Double nota2) {
        this.nome = nome;
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Aluno() {
    }

    public String getAprovacao() {
        double media = nota1 + nota2 / 2;
        if (media < MEDIA) {
            return "Reprovado";
        } else {
            return "Aprovado";
        }
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getDisciplina() {
        return disciplina;
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

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

}
