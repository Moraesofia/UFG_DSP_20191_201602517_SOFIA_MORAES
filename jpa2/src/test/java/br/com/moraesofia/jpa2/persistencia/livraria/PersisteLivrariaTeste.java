package br.com.moraesofia.jpa2.persistencia.livraria;

import br.com.gilmarioarantes.jpaexemplo.model.Livraria;
import br.com.gilmarioarantes.jpaexemplo.model.Livro;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PersisteLivrariaTeste extends LivrariaTeste{

    @Test
    public void persisteLivrariaTest(){

        Livraria livraria = new Livraria();
        livraria.setNome("Livraria UFG");
        List<Livro> livros = new ArrayList<>();
        Livro l1 = new Livro("A história infinita");
        Livro l2 = new Livro("A arte da guerra");
        Livro l3 = new Livro("Hibernate in Action");
        livros.add(l1);
        livros.add(l2);
        livros.add(l3);
        livraria.setLivros(livros);

        Livraria novaLivraria = dao.saveOrUpdate(livraria);

        Assert.assertTrue(novaLivraria.getNome().equals("Livraria UFG"));
    }
}
