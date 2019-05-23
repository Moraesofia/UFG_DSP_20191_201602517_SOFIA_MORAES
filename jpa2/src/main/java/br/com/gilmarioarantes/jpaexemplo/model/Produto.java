
package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Produto implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String descricao;
    private String marca;
    private String unidade;
    private double preco;
    private double quantidadeEstoque;

    public Produto(String tipo, String descricao, String marca, String unidade, double preco, double quantidade){
        this.tipo = tipo;
        this.descricao = descricao;
        this.marca = marca;
        this.unidade = unidade;
        this.preco = preco;
        this.quantidadeEstoque = quantidade;
    }


    public void atualizaEstoque(double quantidade){

        quantidadeEstoque -= quantidade;

    }

    public boolean validaQuantidadeEstoque(double quantidadePedida){
        boolean result = false;
        if(quantidadeEstoque >= quantidadePedida){
            result = true;
        }else{
            System.out.println("Quantidade em estoque insuficiente");
        }

        return result;
    }
}
