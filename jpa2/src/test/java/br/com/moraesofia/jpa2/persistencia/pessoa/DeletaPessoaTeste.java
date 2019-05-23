package br.com.moraesofia.jpa2.persistencia.pessoa;

import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class DeletaPessoaTeste extends PessoaTest{

    @Test
    public void deletaPessoaTeste(){
        Pessoa pessoa = (Pessoa) dao.findById(Pessoa.class,1L);
        if (pessoa != null){
            dao.remove (Pessoa.class,pessoa.getId());

            // This will return null
            Pessoa novaPessoa = (Pessoa) dao.findById(Pessoa.class,1L);
            Assert.assertTrue(novaPessoa == null);
        }else{
            log.error("Erro ao deletar a pessoa!");
            Assert.assertTrue(false);
        }
    }
}
