package com.mbueno.lanchonete.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public class IngredienteDto {

    private Long id;
    private String nome;
    private double valor;
    private Optional<Integer> quantidade = Optional.empty();;

    IngredienteDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "Nome não pode ser vazio.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "Valor não pode ser vazio.")
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Optional<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Optional<Integer> quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "IngredienteDto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + "]";
    }
}
