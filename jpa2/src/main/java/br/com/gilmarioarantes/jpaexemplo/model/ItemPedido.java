package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ItemPedido implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @OneToOne(cascade = CascadeType.ALL)
    private Produto produto;

    private double quantidade;

    @Transient
    private double valorItem;

    public ItemPedido(Pedido ped, Produto prod, double q){
        this.pedido = ped;
        this.produto = prod;
        this.quantidade = q;
    }

    public double getValorItem(){
        double valorItem = quantidade * produto.getPreco();
        return valorItem;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\nProduto\t\t\t\t\tQuantidade\t\tValor Unitário\t\tValor Total");
        sb.append("\n" + this.getProduto().getDescricao() + "\t\t" + this.getQuantidade() + "\t\t\t\t" + this.getProduto().getPreco() +
                "\t\t\t\t" + getValorItem());
        return sb.toString();
    }
}
