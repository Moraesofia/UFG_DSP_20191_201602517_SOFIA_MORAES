package br.com.moraesofia.jpa2.persistencia.veiculo;

import br.com.gilmarioarantes.jpaexemplo.model.Veiculo;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
@Log4j
public class AlteraVeiculoTeste extends VeiculoTest{

    @Test
    public void alteraAnoAnoFabricacaoTeste(){

        Veiculo veiculo = (Veiculo) dao.findById(Veiculo.class,1L);
        if(veiculo != null){
            veiculo.setAnoFabricacao(2016);

            //update vehicle record
            Veiculo novoVeiculo = (Veiculo) dao.saveOrUpdate(veiculo);
            Assert.assertTrue(novoVeiculo.getAnoFabricacao() == 2016);
        }else{
            log.error("Erro ao alterar o ano de fabricação do veículo!");
            Assert.assertTrue(false);
        }
    }

    @Test
    public void alteraAnoAnoModeloTeste(){

        Veiculo veiculo = (Veiculo) dao.findById(Veiculo.class,1L);
        if(veiculo != null){
            veiculo.setAnoModelo(2017);

            //update vehicle record
            Veiculo novoVeiculo = dao.saveOrUpdate(veiculo);
            Assert.assertTrue(novoVeiculo.getAnoModelo() == 2017);
        }else{
            log.error("Erro ao alterar do modelo do veículo!");
            Assert.assertTrue(false);
        }
    }

}
