package com.mbueno.lanchonete.services.impl;

import com.mbueno.lanchonete.entities.Lanche;
import com.mbueno.lanchonete.repositories.LancheRepository;
import com.mbueno.lanchonete.services.LancheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancheServiceImpl implements LancheService {

    private static final Logger log = LoggerFactory.getLogger(LancheServiceImpl.class);

    @Autowired
    private LancheRepository lancheRepository;

    @Override
    public Lanche persistir(Lanche lanche) {
        log.info("Persistindo lanche: {}", lanche);
        return lancheRepository.save(lanche);
    }

    @Override
    public Optional<Lanche> buscaPorId(Long id) {
        log.info("Buscando lanche por ID {}", id);
        return lancheRepository.findById(id);
    }
}
