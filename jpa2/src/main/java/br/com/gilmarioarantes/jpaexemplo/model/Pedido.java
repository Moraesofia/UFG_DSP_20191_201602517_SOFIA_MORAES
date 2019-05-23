package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.gilmarioarantes.jpaexemplo.util.FormataData;
import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Pedido implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date data;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pessoa comprador;

    @Transient
    private double valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    public double obtemValorPedido(){
        double valorPedido = 0;
        for(ItemPedido item : itens){
            valorPedido += item.getValorItem();
        }
        return valorPedido;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("----Imprimindo os dados do Pedido----");
        sb.append("\nId do Pedido: " + this.getId());
        sb.append("\nData do pedido: " + new FormataData().dateToString(this.getData()));
        sb.append("\nNome do Comprador: " + this.getComprador().getNome());
        sb.append("\nValor total do Pedido: " + obtemValorPedido());
        sb.append("\n---Itens----");
        for(ItemPedido ip : itens){
            sb.append(ip.toString());
        }


        return sb.toString();
    }
}
