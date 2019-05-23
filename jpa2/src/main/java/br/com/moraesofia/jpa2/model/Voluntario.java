package br.com.moraesofia.jpa2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Voluntario implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Integer cpf;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Abrigo> abrigosQueTrabalha;




}
