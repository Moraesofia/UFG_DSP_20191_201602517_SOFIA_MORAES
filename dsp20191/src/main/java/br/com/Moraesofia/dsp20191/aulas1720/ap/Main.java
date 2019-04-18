package br.com.Moraesofia.dsp20191.aulas1720.ap;

import java.util.Date;

import br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia.AlteraEntidades;
import br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia.AlterarSalarios;
import br.com.Moraesofia.dsp20191.aulas1720.ap.persistencia.DeletaDados;

public class Main {

    private static boolean status;

    public static void main(String[] args) throws Exception {
        status = true;

        // Altera dados das entidades em suas tabelas.
        AlteraEntidades ae = new AlteraEntidades();
        status = ae.alteraNomeFunc(60L, "Funcionario Alterado");
        status = ae.alteraNomeDept(70L, "Departamento Alterado");
        status = ae.alteraNomeCargo(80L, "Cargo Alterado");

        Date novaData = new Date(System.currentTimeMillis() - 86400000); // - 1 dia em mili seg
        status = ae.alteraDataInicialLotacao(90L, novaData.toString());

        // Alterar o salário de um determinado cargo em determinado departamento.
        AlterarSalarios as = new AlterarSalarios();
        status = as.alterarSalarios(71L, 999);

        // Deleta dados das tabelas
        DeletaDados dd = new DeletaDados();
        status = dd.deletaFuncionario(62L);
        status = dd.deletaDepartamento(72L);
        status = dd.deletaCargo(82L);
        status = dd.deletaLotacao(99L);

        if (!status) {
            throw new Exception("Erro na alteração do banco de dados");
        }

        System.out.println("FIM DA EXECUÇÃO");

    }

}
