package br.com.moraesofia.jpa2.persistencia.pedido;

import br.com.gilmarioarantes.jpaexemplo.model.ItemPedido;
import br.com.gilmarioarantes.jpaexemplo.model.Pedido;
import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import br.com.gilmarioarantes.jpaexemplo.model.Produto;
import br.com.moraesofia.jpa2.persistencia.DaoGenerico;
import br.com.moraesofia.jpa2.persistencia.Produto.ProdutoTest;
import br.com.moraesofia.jpa2.persistencia.pessoa.PessoaTest;
import br.com.gilmarioarantes.jpaexemplo.util.FormataData;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class PersistePedidoTeste extends PedidoTeste{

    @Test
    public void persistePedidoTest(){

        System.out.println("Persiste Pedido Teste");

        Pedido pedido = new Pedido();

        pedido.setData(new FormataData().stringToDate("20/05/2019"));

        Pessoa comprador = new PessoaTest().getDao().findById(Pessoa.class, 1L);

        if(comprador != null){
            pedido.setComprador(comprador);
        }else{
            log.error("Erro ao consultar a Pessoa");
        }

        DaoGenerico<Produto> produtoDao = new DaoGenerico<>();

        Produto p1 = produtoDao.findById(Produto.class,3L);
        if(p1 != null){
            ItemPedido ip1 = new ItemPedido(pedido, p1, 15.0);
            pedido.getItens().add(ip1);
        }else{
            log.error("Erro ao consultar o produto p1");
        }

        Produto p2 = new ProdutoTest().getDao().findById(Produto.class,4L);
        if(p2 != null){
            ItemPedido ip2 = new ItemPedido(pedido, p2, 25.0);
            pedido.getItens().add(ip2);
        }else{
            log.error("Erro ao consultar o produto p2");
        }

        Produto p3 = new ProdutoTest().getDao().findById(Produto.class,5L);
        if(p3 != null){
            ItemPedido ip3 = new ItemPedido(pedido, p3, 150.0);
            pedido.getItens().add(ip3);
        }else{
            log.error("Erro ao consultar o produto p3");
        }

        Produto p4 = new ProdutoTest().getDao().findById(Produto.class,6L);
        if(p4 != null){
            ItemPedido ip4 = new ItemPedido(pedido, p4, 135.0);
            pedido.getItens().add(ip4);
        }else{
            log.error("Erro ao consultar o produto p4");
        }

        Produto p5 = new ProdutoTest().getDao().findById(Produto.class,7L);
        if(p5 != null){
            ItemPedido ip5 = new ItemPedido(pedido, p5, 215.0);
            pedido.getItens().add(ip5);
        }else{
            log.error("Erro ao consultar o produto p5");
        }

        //Imprimindo os dados do pedido
        System.out.println(pedido.toString());


        Pedido novoPedido = dao.saveOrUpdate(pedido);
        //Imprimindo os dados do novo pedido
        System.out.println(novoPedido.toString());


        Assert.assertTrue(novoPedido.getId() == 8L);
    }


}
