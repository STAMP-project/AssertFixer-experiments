package com.mbueno.lanchonete.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoDto {

    private Long id;
    private List<LancheDto> lanches = new ArrayList<>();
    private Optional<Double> valor = Optional.empty();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "Lanche não pode ser vazio.")
    public List<LancheDto> getLanches() {
        return lanches;
    }

    public void setLanches(List<LancheDto> lanches) {
        this.lanches = lanches;
    }

    public Optional<Double> getValor() {
        return valor;
    }

    public void setValor(Optional<Double> valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PedidoDto [id=" + id + ", valor=" + valor + "]";
    }
}
