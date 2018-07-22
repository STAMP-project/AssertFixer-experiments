package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    NAOSELECIONADO(0, "Não selecionado"),
    ADMINISTRADOR(1, "Adiministrador"),
    GERENTE(2, "Gerente"),
    FINANCEIRO(3, "Financeiro"),
    USUARIO(4, "Usuário");

    private Integer codigo;
    private String descricao;

    RoleEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static RoleEnum converteParaEnum(Integer codigo) {
        assert codigo!= null : "O código não pode ser nulo";
        for (RoleEnum paraCada : RoleEnum.values()) {
            if (codigo.equals(paraCada.getCodigo())) {
                return paraCada;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

    public static String descricao(Integer codigo) {
        assert codigo!= null : "O código não pode ser nulo";
        for (RoleEnum paraCada : RoleEnum.values()) {
            if (codigo.equals(paraCada.getCodigo())) {
                return paraCada.getDescricao();
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
