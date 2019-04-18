package br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AlteraEntidades extends PersistenciaJdbc {

    public boolean alteraNomeFunc(Long id, String novoNome) throws SQLException {
        boolean result = false;

        try {
            Funcionario f = new ConsultaDados().consultaFuncPorId(id);

            if (f.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE FUNCIONARIO SET NOME = ? WHERE ID_FUNC = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, novoNome);
                pstmt.setLong(2, id);
                pstmt.executeUpdate();
                result = true;

                System.out.println("O Funcionario de id = " + id + " teve seu nome alterado corretamente!");
                pstmt.close();

            } else {
                System.out.println("Não foi encontrado Funcionario com id = " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        stmt.close();
        connection.close();
        return result;
    }

    public boolean alteraNomeDept(Long id, String novoNome) throws SQLException {
        boolean result = false;

        try {
            Departamento d = new ConsultaDados().consultaDeptPorId(id);

            if (d.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE DEPARTAMENTO SET NOME = ? WHERE ID_DEPT = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, novoNome);
                pstmt.setLong(2, id);
                pstmt.executeUpdate();
                result = true;

                System.out.println("O Departamento de id = " + id + " teve seu nome alterado corretamente!");
                pstmt.close();

            } else {
                System.out.println("Não foi encontrado Departamento com id = " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        stmt.close();
        connection.close();
        return result;
    }

    public boolean alteraNomeCargo(Long id, String novoNome) throws SQLException {
        boolean result = false;

        try {
            Cargo c = new ConsultaDados().consultaCargPorId(id);
            if (c.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE CARGO SET NOME = ? WHERE ID_CARG = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, novoNome);
                pstmt.setLong(2, id);
                pstmt.executeUpdate();
                result = true;

                System.out.println("O Cargo de id = " + id + " teve seu nome alterado corretamente!");
                pstmt.close();

            } else {
                System.out.println("Não foi encontrado Cargo com id = " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        stmt.close();
        connection.close();
        return result;
    }

    public boolean alteraDataInicialLotacao(Long id, String novaData) throws SQLException {
        boolean result = false;

        try {
            Lotacao l = new ConsultaDados().consultaLotaPorId(id);
            if (l.getId() != null) {
                preparaPersistencia();

                String sql = "UPDATE LOTACAO SET DATA_IN = ? WHERE ID_LOTA = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, novaData);
                pstmt.setLong(2, id);
                pstmt.executeUpdate();
                result = true;

                System.out.println("A Lotação de id = " + id + " teve sua data inicial alterada corretamente!");
                pstmt.close();

            } else {
                System.out.println("Não foi encontrada Lotação com id = " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        stmt.close();
        connection.close();
        return result;
    }

}
