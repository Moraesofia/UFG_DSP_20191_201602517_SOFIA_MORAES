package br.com.Moraesofia.aula2528jpa.persistencia;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.Moraesofia.aula2528jpa.model.Veiculo;

public class DeletaVeiculoTeste {

    Logger logger = Logger.getLogger(DeletaVeiculoTeste.class.getName());
    Server server = null;
    VeiculoRepository repository = null;

    @BeforeTest
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void deletaPessoaTeste() {

        Veiculo veiculo = repository.read(1L);
        if (veiculo != null) {
            repository.delete(veiculo);
        }

        // This will return null
        Veiculo novoVeiculo = repository.read(1L);

        Assert.assertTrue(novoVeiculo == null);
    }

}
