package br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia;

import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class DeletaTabelas extends PersistenciaJdbc {

    public boolean excluiTabelaLotacao() throws Exception {

        preparaPersistencia();

        System.out.println("Excluindo a tabela Lotacao");

        String sql = "DROP TABLE IF EXISTS LOTACAO";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotacao excluida com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    public boolean excluiTabelaCargo() throws Exception {

        preparaPersistencia();

        System.out.println("Excluindo a tabela Cargo");

        String sql = "DROP TABLE IF EXISTS CARGO";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Cargo excluida com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    public boolean excluiTabelaDepartamento() throws Exception {

        preparaPersistencia();

        System.out.println("Excluindo a tabela Departamento");

        String sql = "DROP TABLE IF EXISTS DEPARTAMENTO";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamento excluida com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    public boolean excluiTabelaFuncionario() throws Exception {

        preparaPersistencia();

        System.out.println("Excluindo a tabela Funcionario");

        String sql = "DROP TABLE IF EXISTS FUNCIONARIO";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Funcionario excluida com sucesso!");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}
