package br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AlterarSalarios extends PersistenciaJdbc {

    /**
     * Altera o salário dos funcionários de um determinado cargo, lotado em um
     * departamento.
     *
     * @param idCargo
     * @param novoSalario
     * @return
     * @throws Exception
     */
    public boolean alterarSalarios(Long idDept, double novoSalario) throws Exception {
        boolean result = false;

        preparaPersistencia();

        List<Long> idCargs = consultaCargoEmLotacao(idDept);

        for (Long id : idCargs) {

            try {
                String sql = "UPDATE CARGO SET SALARIO = ? WHERE ID_CARG = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setDouble(1, novoSalario);
                pstmt.setLong(2, id);
                pstmt.executeUpdate();
                result = true;

                System.out.println("Salário do Cargo de id = " + id + " alterado corretamente!");
                pstmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // Clean-up environment
        stmt.close();
        connection.close();
        return result;

    }

    private List<Long> consultaCargoEmLotacao(Long idDept) throws Exception {

        preparaPersistencia();

        String sql = "SELECT ID_CARG FROM LOTACAO WHERE ID_DEPT = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, idDept);

        ResultSet rs = pstmt.executeQuery();
        List<Long> idCargos = new ArrayList<>();

        while (rs.next()) {
            idCargos.add(rs.getLong("ID_CARG"));
        }

        rs.close();
        pstmt.close();

        return idCargos;
    }

    // private List<Long> consultaFuncsEmLotacao(Long idCargo, Long idDept) throws
    // Exception {
    //
    // preparaPersistencia();
    //
    // String sql = "SELECT ID_FUNC FROM LOTACAO WHERE ID_CARG = ? AND ID_DEPT = ?";
    // PreparedStatement pstmt = connection.prepareStatement(sql);
    // pstmt.setLong(1, idCargo);
    // pstmt.setLong(2, idDept);
    //
    // ResultSet rs = pstmt.executeQuery();
    // List<Long> idsFuncs = new ArrayList<>();
    //
    // while (rs.next()) {
    // idsFuncs.add(rs.getLong("ID_FUNC"));
    // }
    //
    // rs.close();
    // pstmt.close();
    // stmt.close();
    // connection.close();
    //
    // return idsFuncs;
    // }

}
