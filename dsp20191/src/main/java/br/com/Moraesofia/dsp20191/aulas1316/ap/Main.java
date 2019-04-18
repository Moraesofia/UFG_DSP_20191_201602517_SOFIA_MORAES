package br.com.Moraesofia.dsp20191.aulas1316.ap;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Cargo;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Departamento;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Funcionario;
import br.com.Moraesofia.dsp20191.aulas1316.ap.entidades.Lotacao;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.AlteraTabelas;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.CriaTabelas;
import br.com.Moraesofia.dsp20191.aulas1316.ap.persistencia.PersisteDados;

public class Main {

    private static List<Funcionario> listFunc = new ArrayList<>();

    private static List<Departamento> listDepts = new ArrayList<>();

    private static List<Cargo> listCargos = new ArrayList<>();

    private static List<Lotacao> listLotacoes = new ArrayList<>();

    private static boolean status;

    private static int QNT_FUNC = 10;

    private static int QNT_DEPT = 4;

    private static int QNT_CARGO = 3;

    public static void main(String[] args) throws Exception {

        // Adiciona tabelas
        status = true;
        CriaTabelas ct = new CriaTabelas();
        status = ct.criaTabelaFuncionario();
        status = ct.criaTabelaDepartamento();
        status = ct.criaTabelaCargo();
        status = ct.criaTabelaLotacao();

        // // Deleta Tabelas
        // DeletaTabelas dt = new DeletaTabelas();
        // status = dt.excluiTabelaLotacao();
        // status = dt.excluiTabelaCargo();
        // status = dt.excluiTabelaDepartamento();
        // status = dt.excluiTabelaFuncionario();

        // Altera Tabelas
        AlteraTabelas at = new AlteraTabelas();
        status = at.adocionaFKTabelaLotacao();

        // Adiciona Conteudo nas tabelas
        PersisteDados pd = new PersisteDados();

        // Cria Funcionarios
        criaFuncionarios();
        for (Funcionario f : listFunc) {
            status = pd.persisteFuncionario(f);
        }

        // Cria Departamentos
        criaDepartamentos();
        for (Departamento d : listDepts) {
            status = pd.persisteDepartamento(d);

        }

        // Cria Cargos
        criaCargos();
        for (Cargo c : listCargos) {
            status = pd.persisteCargo(c);
        }

        // Cria Lotacoes
        criaLotacoes();
        for (Lotacao lota : listLotacoes) {
            status = pd.persisteLotacao(lota);
        }

        if (!status) {
            throw new Exception("Erro na criação do banco de dados");
        }

        System.out.println("FIM DA EXECUÇÃO");

    }

    public static void criaFuncionarios() {
        for (int i = 0; i < QNT_FUNC; i++) {

            long id = 60 + i;
            String nome = "Funcionario" + Integer.toString(i);
            long matricula = 22222 + i;

            Funcionario f = new Funcionario(id, nome, matricula);
            listFunc.add(f);

        }

    }

    public static void criaDepartamentos() {
        for (int i = 0; i < QNT_DEPT; i++) {

            long id = 70 + i;
            String nome = "Departamento" + Integer.toString(i);

            Departamento d = new Departamento(id, nome);
            listDepts.add(d);

        }

    }

    public static void criaCargos() {
        for (int i = 0; i < QNT_CARGO; i++) {

            long id = 80 + i;
            String nome = "Cargo" + Integer.toString(i);
            double salario = 100 + i * 100;

            Cargo c = new Cargo(id, nome, salario);
            listCargos.add(c);

        }

    }

    public static void criaLotacoes() throws ParseException {
        // Numero de Lotações igual ao número de funcionários
        for (int i = 0; i < QNT_FUNC; i++) {
            long id = 90 + i;
            Date dataInicial = new Date();
            Date dataFinal = new Date(dataInicial.getTime() + 86400000); // + 1 dia em mili seg
            Random r = new Random();
            Cargo cargo = listCargos.get(r.nextInt(QNT_CARGO));
            Departamento departamento = listDepts.get(r.nextInt(QNT_DEPT));
            Funcionario funcionario = listFunc.get(i);

            Lotacao l = new Lotacao(id, dataInicial.toString(), dataFinal.toString(), cargo, departamento, funcionario);
            listLotacoes.add(l);
        }

    }

}
