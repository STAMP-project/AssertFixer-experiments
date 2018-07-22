package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.EnderecoPessoaJuridica;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.TelefonePessoaJuridica;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(schema = "cliente")
public class PessoaJuridica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoFederal;
    @OneToOne(mappedBy = "pessoaJuridica", cascade = CascadeType.ALL)
    private EnderecoPessoaJuridica enderecoPessoaJuridica;
    @JsonManagedReference
    @ManyToMany
    @JoinTable(schema = "tabela_auxiliar", name = "pessoajuridica_pessoafisica", joinColumns = @JoinColumn(name = "fk_pessoajuridica"),
               inverseJoinColumns = @JoinColumn(name = "fk_pessoafisica"))
    private List<PessoaFisica> sociosProprietarios = new ArrayList<>();
    @OneToMany(mappedBy = "pessoaJuridica")
    private List<TelefonePessoaJuridica> telefonePessoaJuridicas = new ArrayList<>();

    public PessoaJuridica() {
    }
}
