package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Aluno implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aluno_id")
    private Long id;

    private Long matricula;

    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turmas;

    public Aluno(Long matricula){
        this.matricula = matricula;
    }
}
