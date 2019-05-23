package br.com.moraesofia.jpa2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Abrigo implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "abrigo")
    private List<Cachorro> cachorros;

    @OneToOne(mappedBy = "abrigo")
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Voluntario> voluntarios;
}
