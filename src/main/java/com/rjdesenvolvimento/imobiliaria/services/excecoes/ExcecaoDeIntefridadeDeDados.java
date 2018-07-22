package com.rjdesenvolvimento.imobiliaria.services.excecoes;

public class ExcecaoDeIntefridadeDeDados extends RuntimeException {

    public ExcecaoDeIntefridadeDeDados(String mensagem) {
        super(mensagem);
    }

    public ExcecaoDeIntefridadeDeDados(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
