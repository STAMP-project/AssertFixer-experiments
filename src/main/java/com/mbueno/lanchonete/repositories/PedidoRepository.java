package com.mbueno.lanchonete.repositories;

import com.mbueno.lanchonete.entities.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
