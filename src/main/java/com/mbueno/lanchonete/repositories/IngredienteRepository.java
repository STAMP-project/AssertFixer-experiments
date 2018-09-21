package com.mbueno.lanchonete.repositories;

import com.mbueno.lanchonete.entities.Ingrediente;
import org.springframework.data.repository.CrudRepository;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
}
