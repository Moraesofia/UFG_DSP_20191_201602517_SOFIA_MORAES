package br.com.moraesofia.jpa2.persistencia.veiculo;

import br.com.gilmarioarantes.jpaexemplo.model.Veiculo;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class ConsultaVeiculoTeste extends VeiculoTest{

    @Test
    public void consultaPeloIdTest(){

        Veiculo veiculo = (Veiculo) dao.findById(Veiculo.class,1L);
        if(veiculo != null){
            Assert.assertTrue(veiculo.getMarca().equals("Mitsubishi"));
        }else{
            log.error("Erro ao consultar o veículo pelo Id!");
            Assert.assertTrue(false);
        }
    }
/*
    @Test
    public void consultaPelaMarcaTest(){
        List<Veiculo> veiculos = vdao.consultaPelaMarca("Mitsubishi");
        if(veiculos.size() > 0){
            Assert.assertTrue(true);
        }else{
            log.error("Não encontrado nenhum veículo com marca informado!");
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloModeloTest(){
        List<Veiculo> veiculos = vdao.consultaPeloModelo("Pajero Dakar");
        if(veiculos.size() > 0){
            Assert.assertTrue(true);
        }else{
            log.error("Não encontrado nenhum veículo com o modelo informado!");
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloAnoFabricacaoTest(){
        List<Veiculo> veiculos = vdao.consultaPeloAnoFabricacao(2015);
        if(veiculos.size() > 0){
            Assert.assertTrue(true);
        }else{
            log.error("Não encontrado nenhum veículo com o ano de fabricação informado!");
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloAnoModeloTest(){
        List<Veiculo> veiculos = vdao.consultaPeloAnoModelo(2016);
        if(veiculos.size() > 0){
            Assert.assertTrue(true);
        }else{
            log.error("Não encontrado nenhum veículo com o modelo do ano informado!");
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloAnoProprietarioTest(){

    }

    @Test
    public void consultaPelaPlacaTest(){


    }

*/
}
