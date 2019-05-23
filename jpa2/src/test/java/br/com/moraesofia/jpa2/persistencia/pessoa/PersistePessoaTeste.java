package br.com.moraesofia.jpa2.persistencia.pessoa;

import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import br.com.gilmarioarantes.jpaexemplo.util.FormataData;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class PersistePessoaTeste extends PessoaTest{

    @Test
    public void TestaPersistenciaPessoa(){
        System.out.println("Persiste Pessoa Teste");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("John");
        pessoa.setEmail("jorley@goias.gov.br");
        pessoa.setCpf("191");
        //pessoa.setDataCriacao(LocalDateTime.now());
        pessoa.setDataCriacao(new FormataData().stringToDate("14/05/2019"));
        //pessoa.setDataNascimento(LocalDate.of(1993, Month.APRIL, 12));
        pessoa.setDataNascimento(new FormataData().stringToDate("25/05/1985"));

        Pessoa novaPessoa = dao.saveOrUpdate(pessoa);
        if(novaPessoa != null){
            Assert.assertTrue(novaPessoa.getId() == 1L);
        }else{
            log.error("Erro ao persistir a Pessoa");
            Assert.assertTrue(false);
        }
    }
}
