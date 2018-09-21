package com.mbueno.lanchonete.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LancheDto {

    private Long id;
    private String nome;
    private List<IngredienteDto> ingredientes = new ArrayList<>();
    private Optional<Integer> valor = Optional.empty();

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

    @NotEmpty(message = "Ingrediente não pode ser vazio.")
    public List<IngredienteDto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Optional<Integer> getValor() {
        return valor;
    }

    public void setValor(Optional<Integer> valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "LancheDto [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
    }
}
