package br.com.Moraesofia.dsp20191.aulas0508.ap;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Atividade pratica aulas0508.
 *
 * @author sofia
 *
 */
public class TestaConexao {

    private static String PROP_FILE = "conexao.properties";

    public static void main(String[] args) throws IOException {

        Properties prop = getProp();

        Usuario user = getUsuarioProp(prop);
        Conexao con = getConexaoProp(prop);

        System.out.println(user.atributesToString() + con.atributesToString());
    }

    public static Conexao getConexaoProp(Properties prop) throws IOException {
        String sgbd = prop.getProperty("sgbd");
        String tipoConexao = prop.getProperty("tipoConexao");
        String bancoDados = prop.getProperty("bancoDados");
        String urlBd = prop.getProperty("urlBd");
        String sistemaOperacional = getSO();

        Conexao con = new Conexao(sgbd, tipoConexao, bancoDados, urlBd,
                sistemaOperacional);
        return con;
    }

    public static Usuario getUsuarioProp(Properties prop) {
        String nome = prop.getProperty("nome");
        String login = prop.getProperty("usuario");
        String senha = prop.getProperty("senha");

        Usuario user = new Usuario(nome, login, senha);
        return user;
    }

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        FileInputStream file = new FileInputStream(
                classLoader.getResource(PROP_FILE).getFile());
        props.load(file);
        return props;
    }

    public static String getSO() {
        final String OS = System.getProperty("os.name").toLowerCase();
        return OS;
    }

}
