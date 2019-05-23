package br.com.moraesofia.jpa2.persistencia.pessoa;

import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.TesteJPA;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
@Data
public class PessoaTest extends TesteJPA {

    protected DaoGenerico<Pessoa> dao = new DaoGenerico<>();
    /*
    @BeforeTest
    public void configuraDao(){
        System.out.println("----Configurando PessoaDAO----");
        dao = new PessoaDAO();
    }
    */
}
