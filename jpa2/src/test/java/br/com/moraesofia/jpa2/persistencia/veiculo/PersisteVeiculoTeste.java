package br.com.moraesofia.jpa2.persistencia.veiculo;

import br.com.gilmarioarantes.jpaexemplo.model.Pessoa;
import br.com.gilmarioarantes.jpaexemplo.model.Veiculo;
import br.com.moraesofia.jpa2.persistencia.pessoa.PessoaTest;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class PersisteVeiculoTeste extends VeiculoTest{

    @Test
    public void persisteVeiculoTest(){
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Mitsubishi");
        veiculo.setModelo("Pajero Dakar");
        veiculo.setAnoFabricacao(2015);
        veiculo.setAnoModelo(2016);
        veiculo.setPlaca("AMT2432");
        veiculo.setProprietario(new PessoaTest().getDao().findById(Pessoa.class,1L));

        // Create veiculo
        Veiculo novoVeiculo =  (Veiculo) dao.saveOrUpdate(veiculo);
        if(novoVeiculo != null){
            Assert.assertTrue(novoVeiculo.getMarca().equals("Mitsubishi"));
        }else{
            log.error("Erro ao persistir o veiculo");
            Assert.assertTrue(false);
        }
    }
}
