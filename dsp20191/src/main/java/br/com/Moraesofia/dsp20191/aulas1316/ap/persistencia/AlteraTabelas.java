package br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia;

public class AlteraTabelas extends PersistenciaJdbc {

    public boolean adocionaFKTabelaLotacao() throws Exception {

        preparaPersistencia();

        System.out.println("Alterando a Tabela Lotacao");

        String sql1 = "ALTER TABLE LOTACAO " + "ADD FOREIGN KEY (ID_CARG) REFERENCES CARGO(ID_CARG) ON DELETE CASCADE";

        stmt.executeUpdate(sql1);

        String sql2 = "ALTER TABLE LOTACAO "
                + "ADD FOREIGN KEY (ID_DEPT) REFERENCES DEPARTAMENTO(ID_DEPT) ON DELETE CASCADE";

        stmt.executeUpdate(sql2);

        String sql3 = "ALTER TABLE LOTACAO "
                + "ADD FOREIGN KEY (ID_FUNC) REFERENCES FUNCIONARIO(ID_FUNC) ON DELETE CASCADE";

        stmt.executeUpdate(sql3);

        System.out.println(
                "Tabela Lotacao alterada com sucesso! (FK para Departamento, Cargo e Funcionario adicionadas)");

        // STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

    // public boolean adicionaFuncEmLotacao() throws Exception {
    //
    // preparaPersistencia();
    //
    // System.out.println("Alterando a Tabela Lotacao");
    //
    // String sql = "ALTER TABLE LOTACAO " + "ADD COLUMN FUNC LONG NOT NULL";
    //
    // stmt.executeUpdate(sql);
    //
    // System.out.println("Tabela Lotacao alterada com sucesso! (Coluna Funcionario
    // adicionada)");
    //
    // // STEP 4: Clean-up environment
    // stmt.close();
    // connection.close();
    // return true;
    // }

}
