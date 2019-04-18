package br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class ConsultaDados extends PersistenciaJdbc {

    private Funcionario func;
    private Departamento dept;
    private Cargo carg;
    private Lotacao lota;

    public ConsultaDados() {

        func = new Funcionario();
        dept = new Departamento();
        carg = new Cargo();
        lota = new Lotacao();
    }

    public Funcionario consultaFuncPorId(Long id) throws Exception {

        preparaPersistencia();

        String sql = "SELECT * FROM FUNCIONARIO WHERE ID_FUNC = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            func.setId(rs.getLong("ID_FUNC"));
            func.setMatricula(rs.getLong("MATRICULA"));
            func.setNome(rs.getString("NOME"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return func;
    }

    public Departamento consultaDeptPorId(Long id) throws Exception {

        preparaPersistencia();

        String sql = "SELECT * FROM DEPARTAMENTO WHERE ID_DEPT = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            dept.setId(rs.getLong("ID_DEPT"));
            dept.setNome(rs.getString("NOME"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return dept;
    }

    public Cargo consultaCargPorId(Long id) throws Exception {

        preparaPersistencia();

        String sql = "SELECT * FROM CARGO WHERE ID_CARG = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            carg.setId(rs.getLong("ID_CARG"));
            carg.setNome(rs.getString("Nome"));
            carg.setSalario(rs.getDouble("SALARIO"));
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return carg;
    }

    public Lotacao consultaLotaPorId(Long id) throws Exception {

        preparaPersistencia();

        String sql = "SELECT * FROM LOTACAO WHERE ID_LOTA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            lota.setId(rs.getLong("ID_LOTA"));
            lota.setDataFinal(rs.getString("DATA_FI"));
            lota.setDataInicial(rs.getString("DATA_IN"));

            Departamento d = new Departamento();
            d.setId(rs.getLong("ID_DEPT"));
            lota.setDepartamento(d);

            Cargo c = new Cargo();
            c.setId(rs.getLong("ID_CARG"));
            lota.setCargo(c);

            Funcionario f = new Funcionario();
            f.setId(rs.getLong("ID_FUNC"));
            lota.setFuncionario(f);
        }

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return lota;
    }

}
