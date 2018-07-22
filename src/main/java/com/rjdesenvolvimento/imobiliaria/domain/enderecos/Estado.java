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
public class Estado implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "fk_pais")
    private Pais pais;
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
