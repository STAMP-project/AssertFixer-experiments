package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(schema = "endereco")
public class TelefonePessoaJuridica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    @ManyToOne
    @JoinColumn(name = "fk_pessoajuridica")
    private PessoaJuridica pessoaJuridica;

    public TelefonePessoaJuridica() {
    }
}
