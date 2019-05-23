package br.com.moraesofia.jpa2.persistencia.Produto;

import br.com.gilmarioarantes.jpaexemplo.model.Produto;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class PersisteProdutoTeste extends ProdutoTest{


    @Test
    public void persisteProdutoTest(){
        System.out.println("Persiste Produto Test");
        List<Produto> produtos = geraProdutos();
        for(Produto p : produtos){
            Produto prod = dao.saveOrUpdate(p);
        }
        List<Produto> produtosPersistidos = dao.getList(Produto.class);
        Assert.assertTrue(produtosPersistidos.size() == 5);
    }


    private List<Produto> geraProdutos(){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Gênero Alimentício", "Arroz Agulhinha Tipo 1", "Cristal", "Pacote 5kg",12.0,2000.0));
        produtos.add(new Produto("Gênero Alimentício", "Arroz Agulhinha Tipo 1", "Barão","Pacote 5kg",11.5,1500.0));
        produtos.add(new Produto("Produto Limpeza", "Sabão em Pó", "Omo","Caixa 1kg",7.9,500.0));
        produtos.add(new Produto("Gênero Alimentício", "Feijão Carioca", "Dona Cota","kg",5.2,200.0));
        produtos.add(new Produto("Gênero Alimentício", "Óleo Soja", "Liza","Lata 900ml",3.5,800.0));
        return produtos;
    }
}
