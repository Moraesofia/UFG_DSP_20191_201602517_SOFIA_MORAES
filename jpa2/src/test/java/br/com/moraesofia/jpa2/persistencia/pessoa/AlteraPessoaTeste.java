package br.com.moraesofia.jpa2.persistencia.pessoa;

import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

@Log4j
public class AlteraPessoaTeste extends PessoaTest{

    @Test
    public void alteraNomeTeste(){
        Pessoa pessoa = dao.findById(Pessoa.class,1L);
            if(pessoa != null){
                //pessoa.setDataAlteracao(LocalDateTime.now());
                pessoa.setDataAlteracao(new Date());
                pessoa.setNome("Jane");
                //update person record
                Pessoa novaPessoa = dao.saveOrUpdate(pessoa);
                Assert.assertTrue(novaPessoa.getNome().equals("Jane"));
            }else{
                log.error("Erro ao alterar a pessoa!");
                Assert.assertTrue(false);
        }
    }
}
