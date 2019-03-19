package br.com.Moraesofia.dsp20191.aulas0104.as;

public class UnidadeFederacao {

    private int uf_id;

    private String uf_sigla;

    private String uf_nome;

    private int uf_cod;

    /**
     * Construtor para a classe UnidadeFederacao.
     * 
     * @param uf_id
     * @param uf_sigla
     * @param uf_nome
     * @param uf_cod
     */
    public UnidadeFederacao(int uf_id, String uf_sigla, String uf_nome,
            int uf_cod) {
        super();
        this.uf_id = uf_id;
        this.uf_sigla = uf_sigla;
        this.uf_nome = uf_nome;
        this.uf_cod = uf_cod;
    }

    public int getUf_id() {
        return uf_id;
    }

    public void setUf_id(int uf_id) {
        this.uf_id = uf_id;
    }

    public String getUf_sigla() {
        return uf_sigla;
    }

    public void setUf_sigla(String uf_sigla) {
        this.uf_sigla = uf_sigla;
    }

    public String getUf_nome() {
        return uf_nome;
    }

    public void setUf_nome(String uf_nome) {
        this.uf_nome = uf_nome;
    }

    public int getUf_cod() {
        return uf_cod;
    }

    public void setUf_cod(int uf_cod) {
        this.uf_cod = uf_cod;
    }

}
