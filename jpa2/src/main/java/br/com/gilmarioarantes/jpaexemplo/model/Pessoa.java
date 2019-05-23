package br.com.gilmarioarantes.jpaexemplo.model;


import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Pessoa implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cpf;

    private String nome;

    private String email;

    //private LocalDate dataNascimento;
    private Date dataNascimento;

    //private LocalDateTime dataCriacao;

    private Date dataCriacao;

    //private LocalDateTime dataAlteracao;

    private Date dataAlteracao;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    public void adicionaVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo){
        Iterator<Veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()){
            Veiculo veiculoRemover = iterator.next();
            if (veiculoRemover.getModelo().equals(veiculo.getModelo())){
                iterator.remove();
            }
        }
    }

    public void adicionaPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido){
        Iterator<Pedido> iterator = pedidos.iterator();
        while(iterator.hasNext()){
            Pedido pedidoRemover = iterator.next();
            if(pedidoRemover.getValorTotal() == pedido.getValorTotal()){
                iterator.remove();
            }
        }
    }
}
