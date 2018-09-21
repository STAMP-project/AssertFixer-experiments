package com.mbueno.lanchonete.services.impl;

import com.mbueno.lanchonete.entities.Pedido;
import com.mbueno.lanchonete.repositories.PedidoRepository;
import com.mbueno.lanchonete.services.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private static final Logger log = LoggerFactory.getLogger(LancheServiceImpl.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public Pedido persistir(Pedido pedido) {
        log.info("Persistindo lanche: {}", pedido);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> buscaPorId(Long id) {
        log.info("Buscando pedido por ID {}", id);
        return pedidoRepository.findById(id);
    }
}
