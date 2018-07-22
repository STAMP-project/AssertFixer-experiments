package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.EnderecoPessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.TelefonePessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(schema = "cliente")
public class PessoaFisica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
    @OneToOne(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
    private Usuario usuario;
    @OneToMany(mappedBy = "pessoaFisica")
    private List<TelefonePessoaFisica> telefonePessoaFisicas = new ArrayList<>();
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(schema = "tabela_auxiliar", name = "pessoafisica_endereco", joinColumns = @JoinColumn(name = "fk_pessoafisica"),
            inverseJoinColumns = @JoinColumn(name = "fk_endereco"))
    private List<EnderecoPessoaFisica> enderecoPessoaFisicas = new ArrayList<>();
    @JsonBackReference
    @ManyToMany(mappedBy = "sociosProprietarios", cascade = CascadeType.ALL)
    private List<PessoaJuridica> empresas = new ArrayList<>();


    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf, String rg, Date dataDeNascimento, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataDeNascimento = dataDeNascimento;
        this.usuario = usuario;
    }
}
