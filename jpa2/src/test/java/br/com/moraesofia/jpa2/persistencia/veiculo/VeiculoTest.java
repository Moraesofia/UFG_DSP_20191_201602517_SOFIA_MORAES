package br.com.moraesofia.jpa2.persistencia.veiculo;

import br.com.gilmarioarantes.jpaexemplo.model.Veiculo;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.TesteJPA;
import lombok.Data;

@Data
public class VeiculoTest extends TesteJPA {

    protected DaoGenerico<Veiculo> dao = new DaoGenerico<>();
    /*
    @BeforeTest
    public void configuraDao(){
        dao = new VeiculoDAO();
    }

     */
}
