package br.com.Moraesofia.aula2528jpa.persistencia;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.Moraesofia.aula2528jpa.model.Veiculo;

public class ConsultaVeiculoTeste {

    Logger logger = Logger.getLogger(ConsultaVeiculoTeste.class.getName());

    VeiculoRepository repository;

    Server server;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void consultaPeloIdTeste() {
        Veiculo veiculo = repository.read(1L);
        System.out.println("Marca: " + veiculo.getMarca() + "Modelo: " + veiculo.getModelo());
        Assert.assertTrue(veiculo != null);
    }

}
