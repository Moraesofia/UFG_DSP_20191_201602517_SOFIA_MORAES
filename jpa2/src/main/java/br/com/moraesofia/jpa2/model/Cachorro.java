package br.com.moraesofia.jpa2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Data
@NoArgsConstructor
@Entity
public class Cachorro implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Abrigo abrigo;

}
