package com.mbueno.lanchonete.services;

import com.mbueno.lanchonete.entities.Lanche;

import java.util.Optional;

public interface LancheService {

    /**
     * Cadastra um lanche na base
     *
     * @param lanche
     * @return
     */
    Lanche persistir(Lanche lanche);

    /**
     * Busca Lanche por id
     *
     * @param id
     * @return
     */
    Optional<Lanche> buscaPorId(Long id);
}
