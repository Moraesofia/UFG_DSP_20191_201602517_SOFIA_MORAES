package br.com.Moraesofia.dsp20191.aulas0508.ap;

public class Conexao {

    private String sgbd;

    private String tipoConexao;

    private String bancoDados;

    private String urlBd;

    private String sistemaOperacional;

    public Conexao(String sgbd, String tipoConexao, String bancoDados,
            String urlBd, String sistemaOperacional) {
        super();
        this.sgbd = sgbd;
        this.tipoConexao = tipoConexao;
        this.bancoDados = bancoDados;
        this.urlBd = urlBd;
        this.sistemaOperacional = sistemaOperacional;
    }

    public String atributesToString() {
        StringBuilder at = new StringBuilder();
        at.append("SGBD: " + this.sgbd + "\n");
        at.append("Tipo Conexao: " + this.tipoConexao + "\n");
        at.append("Banco: " + this.bancoDados + "\n");
        at.append("Url Banco: " + this.urlBd + "\n");
        at.append("SO: " + this.sistemaOperacional + "\n");

        return at.toString();

    }

}
