package com.mbueno.lanchonete.services.impl;

import com.mbueno.lanchonete.entities.Ingrediente;
import com.mbueno.lanchonete.repositories.IngredienteRepository;
import com.mbueno.lanchonete.services.IngredienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    private static final Logger log = LoggerFactory.getLogger(IngredienteServiceImpl.class);

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public Ingrediente persistir(Ingrediente ingrediente) {
        log.info("Persistindo ingrediente: {}", ingrediente);
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public Optional<Ingrediente> buscaPorId(Long id) {
        log.info("Buscando ingrediente por ID {}", id);
        return ingredienteRepository.findById(id);
    }
}
