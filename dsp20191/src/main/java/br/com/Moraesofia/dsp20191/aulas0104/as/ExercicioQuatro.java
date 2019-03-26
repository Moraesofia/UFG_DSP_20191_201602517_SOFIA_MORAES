package br.com.Moraesofia.dsp20191.aulas0104.as;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioQuatro {

    /**
     * Nome do arquivo csv a ser lido.
     */
    private static String CSV_NAME = "UF.csv";

    /**
     * Numero de colunas com informações para a classe UnidadeFederação.
     */
    private static int COLUMNS = 4;

    /**
     * Numero de linhas para pular no arquivo csv.
     */
    private static int SKIP = 1;

    public static void main(String[] args) throws IOException {

        List<String> bufSaida = lerCsv();

        List<UnidadeFederacao> listEst = extrairUFs(bufSaida);

        imprimirUFs(listEst);
    }

    public static void imprimirUFs(List<UnidadeFederacao> listEst) {
        System.out.println("UNIDADES FEDERATIVAS DO BRASIL");
        for (UnidadeFederacao uf : listEst) {
            System.out.println("ID: " + uf.getUf_id());
            System.out.println("SIGLA: " + uf.getUf_sigla());
            System.out.println("NOME: " + uf.getUf_nome());
            System.out.println("COD: " + uf.getUf_cod());
            System.out.println("------------------------------");
        }
    }

    public static List<UnidadeFederacao> extrairUFs(List<String> bufSaida) {
        List<UnidadeFederacao> listEst = new ArrayList<>();
        for (String row : bufSaida) {
            String[] tupla = row.split(",");

            if (tupla.length != COLUMNS) {
                break;
            }

            UnidadeFederacao unidadeFederacao = new UnidadeFederacao(tupla[0],
                    tupla[1], tupla[2], tupla[3]);
            listEst.add(unidadeFederacao);
        }
        return listEst;
    }

    public static List<String> lerCsv()
            throws FileNotFoundException, IOException {
        String linha;
        BufferedReader br = new BufferedReader(new FileReader(CSV_NAME));
        List<String> bufSaida = new ArrayList<>();
        int count = 0;
        while ((linha = br.readLine()) != null) {

            if (count < SKIP) {
                count++;
            } else {
                bufSaida.add(linha);
            }
        }
        br.close();
        return bufSaida;
    }

}
