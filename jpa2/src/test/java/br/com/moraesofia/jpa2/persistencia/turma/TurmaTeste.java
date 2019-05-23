package br.com.moraesofia.jpa2.persistencia.turma;

import br.com.gilmarioarantes.jpaexemplo.model.Turma;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.TesteJPA;
import lombok.Data;

@Data
public class TurmaTeste extends TesteJPA {

    protected DaoGenerico<Turma> dao = new DaoGenerico<>();

}
