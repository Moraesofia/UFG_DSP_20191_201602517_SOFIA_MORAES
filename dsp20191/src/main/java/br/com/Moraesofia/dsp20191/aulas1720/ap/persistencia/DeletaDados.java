package br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class DeletaDados extends PersistenciaJdbc {

    public boolean deletaFuncionario(Long id) throws SQLException {
        boolean result = false;
        try {
            Funcionario func = new ConsultaDados().consultaFuncPorId(id);
            if (func.getId() != null) {
                preparaPersistencia();

                String sql = "DELETE FROM FUNCIONARIO WHERE ID_FUNC = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Funcionario com id = " + id + " foi excluido corretamente!");
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

    public boolean deletaDepartamento(Long id) throws SQLException {
        boolean result = false;
        try {
            Departamento dept = new ConsultaDados().consultaDeptPorId(id);
            if (dept.getId() != null) {
                preparaPersistencia();

                String sql = "DELETE FROM DEPARTAMENTO WHERE ID_DEPT = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Departamento com id = " + id + " foi excluido corretamente!");
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

    public boolean deletaCargo(Long id) throws SQLException {
        boolean result = false;
        try {
            Cargo carg = new ConsultaDados().consultaCargPorId(id);
            if (carg.getId() != null) {
                preparaPersistencia();

                String sql = "DELETE FROM CARGO WHERE ID_CARG = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Cargo com id = " + id + " foi excluido corretamente!");
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

    public boolean deletaLotacao(Long id) throws SQLException {
        boolean result = false;
        try {
            Lotacao lota = new ConsultaDados().consultaLotaPorId(id);
            if (lota.getId() != null) {
                preparaPersistencia();

                String sql = "DELETE FROM LOTACAO WHERE ID_LOTA = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1, id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("A Lotação com id = " + id + " foi excluída corretamente!");
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
