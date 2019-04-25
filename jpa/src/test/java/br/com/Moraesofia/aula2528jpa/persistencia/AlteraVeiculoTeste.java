package br.com.Moraesofia.aula2528jpa.persistencia;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.Moraesofia.aula2528jpa.model.Veiculo;

public class AlteraVeiculoTeste {
    Logger logger = Logger.getLogger(AlteraVeiculoTeste.class.getName());

    Server server = null;
    VeiculoRepository repository = null;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void alteraNomeTeste() {
        Veiculo veiculo = repository.read(1L);
        String novoModelo = "Fox";
        if (veiculo != null) {

        }
        veiculo.setModelo(novoModelo);
        // update person record
        repository.update(veiculo);

        System.out.println("Modelo do veiculo: " + veiculo.getModelo());

        Assert.assertTrue(veiculo.getModelo().equals(novoModelo));
    }
}
