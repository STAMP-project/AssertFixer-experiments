package com.rjdesenvolvimento.imobiliaria.resources.excecoes;

import com.rjdesenvolvimento.imobiliaria.services.excecoes.ExcecaoDeIntefridadeDeDados;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ExcecaoObjetoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorDeExcecaoDeRecurso {

    @ExceptionHandler(ExcecaoObjetoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ExcecaoObjetoNaoEncontrado erro, HttpServletRequest request) {
        ErroPadrao erroPadrao = new ErroPadrao(HttpStatus.NOT_FOUND.value(), erro.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
    }

    @ExceptionHandler(ExcecaoDeIntefridadeDeDados.class)
    public ResponseEntity<ErroPadrao> integridadeDeDados(ExcecaoDeIntefridadeDeDados erro, HttpServletRequest request) {
        ErroPadrao erroPadrao = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), erro.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadrao);
    }
}