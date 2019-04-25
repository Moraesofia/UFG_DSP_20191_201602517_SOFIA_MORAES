package br.com.Moraesofia.aula2528jpa.persistencia;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.Moraesofia.aula2528jpa.model.Veiculo;
import br.com.Moraesofia.aula2528jpa.persistencia.VeiculoRepository;
import br.com.Moraesofia.aula2528jpa.persistencia.VeiculoRepositoryImpl;

public class PersisteVeiculoTeste {

    Logger logger = Logger.getLogger(PersisteVeiculoTeste.class.getName());

    Server server = null;
    VeiculoRepository repository;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void TestaPersistenciaVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setAnoFabricacao(2019);
        veiculo.setAnoModelo(2017);
        veiculo.setMarca("Ford");
        veiculo.setModelo("Ka");
        veiculo.setPotenciaMotor(100);

        // Create veiculo
        Veiculo newVeiculo = repository.create(veiculo);
        System.out.println("Id do veiculo: " + newVeiculo.getId());
        Assert.assertTrue(newVeiculo != null);
    }

}
