package br.com.moraesofia.jpa2.persistencia.pessoa;

import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class ConsultaPessoaTeste extends PessoaTest{

    @Test
    public void consultaPeloIdTest(){
        Pessoa pessoa = dao.findById(Pessoa.class,1L);
        if(pessoa != null){
            Assert.assertTrue(pessoa.getNome().equals("John"));
        }else{
            log.error("Erro ao consultar a Pessoa pelo Id!");
            Assert.assertTrue(false);
        }
    }
/*
    @Test
    public void consultaPeloNomeTest(){
        try{
            List<Pessoa> pessoas = pdao.consultaPeloNome("John");
            Assert.assertTrue(pessoas.size() > 0);
        }catch (Exception e){
            log.error("Erro ao consultar a Pessoa pelo Nome!",e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloCpfTest(){
        Pessoa pessoa;
        try{
            pessoa = pdao.consultaPeloCPF("191");
            Assert.assertTrue(pessoa.getNome().equals("John"));
        }catch (Exception e){
            log.error("Erro ao consultar a Pessoa pelo Cpf!",e);
            Assert.assertTrue(false);
        }
    }

 */
}
