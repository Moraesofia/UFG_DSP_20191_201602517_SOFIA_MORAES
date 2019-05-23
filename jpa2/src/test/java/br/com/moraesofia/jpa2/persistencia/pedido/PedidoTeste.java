package br.com.moraesofia.jpa2.persistencia.pedido;

import br.com.gilmarioarantes.jpaexemplo.model.Pedido;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.TesteJPA;
import lombok.Data;

@Data
public class PedidoTeste extends TesteJPA {

    protected DaoGenerico<Pedido> dao = new DaoGenerico<>();

    /*
    @BeforeTest
    public void configuraDao(){
        System.out.println("Configurando o PedidoDAO");
        dao = new PedidoDAO();
    }
     */
}
