package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Veiculo implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;

    private String modelo;

    private Integer anoFabricacao;

    private Integer anoModelo;

    private String placa;

    @ManyToOne
    private Pessoa proprietario;

}
