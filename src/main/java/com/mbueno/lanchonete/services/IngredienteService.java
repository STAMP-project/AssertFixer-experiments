package com.mbueno.lanchonete.services;

import com.mbueno.lanchonete.entities.Ingrediente;

import java.util.Optional;

public interface IngredienteService {

    /**
     * Cadastra um novo ingrediente
     *
     * @param ingrediente
     * @return Ingrediente
     */
    Ingrediente persistir(Ingrediente ingrediente);

    /**
     * Busca ingrediente por id
     *
     * @param id
     * @return Ingrediente
     */
    Optional<Ingrediente> buscaPorId(Long id);
}
