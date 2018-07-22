package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum TelefoneEnum {

    NAOSELECIONADO(0, "Não selecionado"),
    CELULAR(1, "Celular"),
    COMERCIAL(2, "Comercial"),
    RESIDENCIAL(3, "Residencial");

    private Integer codigo;
    private String descricao;

    TelefoneEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TelefoneEnum converteParaEnum(Integer codigo) {
        assert codigo != null : "O código não pode ser nulo";
        for (TelefoneEnum paraCada : TelefoneEnum.values()) {
            if (codigo.equals(paraCada.getCodigo())) {
                return paraCada;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

    public static String descricao(Integer codigo) {
        assert codigo != null : "O código não pode ser nulo";
        for (TelefoneEnum paraCada : TelefoneEnum.values()) {
            if(codigo.equals(paraCada.getCodigo())) {
                return paraCada.getDescricao();
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
