package com.rjdesenvolvimento.imobiliaria.domain.dto;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
public class PessoaFisicaDto implements Serializable {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    public PessoaFisicaDto() {
    }

    public PessoaFisicaDto(PessoaFisica pessoaFisica) {
        this.id = pessoaFisica.getId();
        this.nome = pessoaFisica.getNome();
        this.cpf = pessoaFisica.getCpf();
        this.rg = pessoaFisica.getRg();
        this.dataDeNascimento = pessoaFisica.getDataDeNascimento();
    }
}
