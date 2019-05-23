package br.com.moraesofia.jpa2.persistencia.livraria;

import br.com.gilmarioarantes.jpaexemplo.model.Livraria;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.TesteJPA;
import lombok.Data;

@Data
public class LivrariaTeste extends TesteJPA {

    protected DaoGenerico<Livraria> dao = new DaoGenerico<>();
}
