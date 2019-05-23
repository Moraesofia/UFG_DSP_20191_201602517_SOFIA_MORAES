package br.com.moraesofia.jpa2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Endereco implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Abrigo abrigo;

    private String bairro;

    private String rua;

    private Integer numero;
}
