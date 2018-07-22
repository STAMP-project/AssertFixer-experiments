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
public class Cidade implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "fk_estado")
    private Estado estado;
    @OneToMany(mappedBy = "cidade")
    private List<EnderecoPessoaFisica> enderecoPessoaFisicas = new ArrayList<>();
    @OneToMany(mappedBy = "cidade")
    private List<EnderecoPessoaJuridica> enderecoPessoaJuridicas = new ArrayList<>();

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }
}
