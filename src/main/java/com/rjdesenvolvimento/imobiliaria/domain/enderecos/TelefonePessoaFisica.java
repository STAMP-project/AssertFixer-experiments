package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.TelefoneEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(schema = "endereco")
public class TelefonePessoaFisica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Integer tipoDeTelefone;
    @ManyToOne
    @JoinColumn(name = "fk_pessoafisica")
    private PessoaFisica pessoaFisica;

    public TelefonePessoaFisica() {
    }

    public TelefonePessoaFisica(String numero, TelefoneEnum tipoDeTelefone) {
        this.numero = numero;
        this.tipoDeTelefone = tipoDeTelefone.getCodigo();
    }

    public TelefoneEnum getTipoDeTelefone() {
        return TelefoneEnum.converteParaEnum(tipoDeTelefone);
    }

    public void setTipoDeTelefone(TelefoneEnum tipoDeTelefone) {
        this.tipoDeTelefone = tipoDeTelefone.getCodigo();
    }

    public String descricaoTipoTelefone() {
        return TelefoneEnum.descricao(tipoDeTelefone);
    }
}
