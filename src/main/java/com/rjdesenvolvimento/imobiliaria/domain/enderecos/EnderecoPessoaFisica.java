package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(schema = "endereco")
public class EnderecoPessoaFisica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "fk_cidade")
    private Cidade cidade;
    @JsonBackReference
    @ManyToMany(mappedBy = "enderecoPessoaFisicas", cascade = CascadeType.ALL)
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public EnderecoPessoaFisica() {
    }
}
