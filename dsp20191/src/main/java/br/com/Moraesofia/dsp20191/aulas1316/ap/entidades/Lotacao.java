package br.com.Moraesofia.dsp20191.aulas1316.ap.entidades;

import java.util.Date;

public class Lotacao {

    private Long id;
    private Date dataInicial;
    private Date dataFinal;
    private Cargo cargo;
    private Departamento departamento;

    public Lotacao(Long id, Date dataInicial, Date dataFinal, Cargo cargo, Departamento departamento) {
        super();
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

}
