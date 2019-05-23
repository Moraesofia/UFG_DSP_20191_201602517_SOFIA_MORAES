package br.com.gilmarioarantes.jpaexemplo.model;

import br.com.moraesofia.jpa2.model.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Livro implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "livro_id")
    private Long id;

    private String titulo;

    public Livro(String titulo){
        this.titulo = titulo;
    }


}
