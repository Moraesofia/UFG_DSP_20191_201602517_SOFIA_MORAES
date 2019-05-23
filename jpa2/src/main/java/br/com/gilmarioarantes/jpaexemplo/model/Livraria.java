package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Livraria implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "livraria_id")
    private Long id;

    private String nome;
    @ManyToMany
    @JoinTable(name = "livraria_livros",
            joinColumns = {@JoinColumn(name = "livraria_id")},
            inverseJoinColumns = {@JoinColumn(name = "livro_id")})
    private List<Livro> livros;
}
