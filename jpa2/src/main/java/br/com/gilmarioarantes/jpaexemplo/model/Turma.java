package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Turma implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "turma_id")
    private Long id;

    private String semestre;

    private String disciplina;

    @ManyToMany
    @JoinTable(name = "turma_alunos",
            joinColumns = {@JoinColumn(name = "turma_id")},
            inverseJoinColumns = {@JoinColumn(name = "aluno_id")})
    private List<Aluno> alunos;
}
