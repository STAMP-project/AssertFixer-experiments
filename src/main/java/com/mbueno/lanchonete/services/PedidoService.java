package com.mbueno.lanchonete.services;

import com.mbueno.lanchonete.entities.Pedido;

import java.util.Optional;

public interface PedidoService {

    /**
     * Cadastra um novo pedido
     *
     * @param pedido
     * @return Pedido
     */
    Pedido persistir(Pedido pedido);

    /**
     * Busca pedido por id
     *
     * @param id
     * @return Pedido
     */
    Optional<Pedido> buscaPorId(Long id);
}
