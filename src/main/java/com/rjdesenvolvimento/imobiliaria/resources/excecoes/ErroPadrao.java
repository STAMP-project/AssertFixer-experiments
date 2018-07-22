package com.rjdesenvolvimento.imobiliaria.resources.excecoes;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErroPadrao implements Serializable {

    private Integer status;
    private String mensagem;
    private Long timeStamp;

    public ErroPadrao(Integer status, String mensagem, Long timeStamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timeStamp = timeStamp;
    }


}
