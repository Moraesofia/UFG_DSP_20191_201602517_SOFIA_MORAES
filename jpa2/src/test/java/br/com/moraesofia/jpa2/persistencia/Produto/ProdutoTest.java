package br.com.moraesofia.jpa2.persistencia.Produto;

import br.com.gilmarioarantes.jpaexemplo.model.Produto;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.TesteJPA;
import lombok.Data;

@Data
public class ProdutoTest extends TesteJPA {

    protected DaoGenerico<Produto> dao = new DaoGenerico<>();

    /*
    @BeforeTest
    public void configuraDao(){
        System.out.println("Configurando o produtoDAO");
        dao = new ProdutoDAO();
    }
    */

}
