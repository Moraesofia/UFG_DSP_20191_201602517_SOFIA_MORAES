package br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia;

import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class CriaTabelas extends PersistenciaJdbc {

    public boolean criaTabelaFuncionario() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Funcionario");

        String sql = "CREATE TABLE IF NOT EXISTS FUNCIONARIO(" + "ID_FUNC LONG NOT NULL PRIMARY KEY,"
                + "NOME VARCHAR(100) NOT NULL," + "MATRICULA LONG NOT NULL," + ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Funcionario criada com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    public boolean criaTabelaDepartamento() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Departamento");

        String sql = "CREATE TABLE IF NOT EXISTS DEPARTAMENTO(" + "ID_DEPT LONG NOT NULL PRIMARY KEY,"
                + "NOME VARCHAR(100) NOT NULL" + ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamento criada com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    public boolean criaTabelaCargo() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Cargo");

        String sql = "CREATE TABLE IF NOT EXISTS CARGO(" + "ID_CARG LONG NOT NULL PRIMARY KEY,"
                + "NOME VARCHAR(100) NOT NULL," + "SALARIO DECIMAL(5,2) NOT NULL," + ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Cargo criada com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    public boolean criaTabelaLotacao() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Lotacao");

        String sql = "CREATE TABLE IF NOT EXISTS LOTACAO(" + "ID_LOTA LONG NOT NULL PRIMARY KEY,"
                + "DATA_IN VARCHAR(30) NOT NULL," + "DATA_FI VARCHAR(30) NOT NULL," + "ID_CARG LONG NOT NULL,"
                + "ID_DEPT LONG NOT NULL," + "ID_FUNC LONG NOT NULL" + ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotacao criada com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}
