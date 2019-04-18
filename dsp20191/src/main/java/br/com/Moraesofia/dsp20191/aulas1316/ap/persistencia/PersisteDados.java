package br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia;

import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class PersisteDados extends PersistenciaJdbc {

    public boolean persisteFuncionario(Funcionario f) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIO " + "VALUES('" + f.getId() + "','" + f.getNome() + "','"
                + f.getMatricula() + "')";

        stmt.executeUpdate(sql);
        System.out.println("O Funcionario foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

    public boolean persisteDepartamento(Departamento d) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTO " + "VALUES('" + d.getId() + "','" + d.getNome() + "')";

        stmt.executeUpdate(sql);
        System.out.println("O Departamento foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

    public boolean persisteCargo(Cargo c) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO CARGO " + "VALUES('" + c.getId() + "','" + c.getNome() + "','" + c.getSalario()
                + "')";

        stmt.executeUpdate(sql);
        System.out.println("O Cargo foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

    public boolean persisteLotacao(Lotacao l) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO LOTACAO " + "VALUES('" + l.getId() + "','" + l.getDataInicial() + "','"
                + l.getDataFinal() + "','" + l.getCargo().getId() + "','" + l.getDepartamento().getId() + "','"
                + l.getFuncionario().getId() + "')";

        stmt.executeUpdate(sql);
        System.out.println("A Lotacao foi persistida corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

}
