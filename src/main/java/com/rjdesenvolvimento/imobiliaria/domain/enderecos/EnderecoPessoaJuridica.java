package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(schema = "endereco")
public class EnderecoPessoaJuridica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "fk_cidade")
    private Cidade cidade;
    @OneToOne
    @MapsId
    @JoinColumn(name = "fk_pessoajuridica")
    private PessoaJuridica pessoaJuridica;

    public EnderecoPessoaJuridica() {
    }
}
