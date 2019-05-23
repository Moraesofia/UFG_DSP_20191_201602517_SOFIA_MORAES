package br.com.moraesofia.jpa2.persistencia;

import lombok.extern.log4j.Log4j;
import org.h2.tools.Server;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.SQLException;

@Log4j
public class TesteJPA {

    protected static Server server = null;

    @BeforeSuite
    public void setup() throws SQLException{
        System.out.println("-----Iniciando o Server-----");
        server = Server.createTcpServer().start();
    }

    @AfterSuite
    public void after(){
        System.out.println("-----Encerrando o Server-----");
        if(server != null){
            server.stop();
        }
    }
}
