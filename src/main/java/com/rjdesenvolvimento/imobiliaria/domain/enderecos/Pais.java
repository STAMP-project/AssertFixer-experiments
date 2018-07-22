package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(schema = "endereco")
public class Pais implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }
}
