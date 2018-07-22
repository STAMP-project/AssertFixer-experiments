package com.rjdesenvolvimento.imobiliaria.services.excecoes;

public class ExcecaoObjetoNaoEncontrado extends RuntimeException {

    public ExcecaoObjetoNaoEncontrado(String mensagem) {
        super(mensagem);
    }

    public ExcecaoObjetoNaoEncontrado(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
