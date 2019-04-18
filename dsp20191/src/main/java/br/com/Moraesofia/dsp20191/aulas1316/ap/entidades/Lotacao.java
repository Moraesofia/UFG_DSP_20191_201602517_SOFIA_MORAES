package br.com.Moraesofia.dsp20191.aulas1316.ap.entidades;

public class Lotacao {

    private Long id;
    private String dataInicial;
    private String dataFinal;
    private Cargo cargo;
    private Departamento departamento;
    private Funcionario funcionario;

    public Lotacao(Long id, String dataInicial, String dataFinal, Cargo cargo, Departamento departamento,
            Funcionario funcionario) {
        super();
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cargo = cargo;
        this.departamento = departamento;
        this.funcionario = funcionario;
    }

    public Lotacao() {
    }

    public Long getId() {
        return id;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
