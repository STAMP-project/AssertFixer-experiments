package com.mbueno.lanchonete.repositories;

import com.mbueno.lanchonete.entities.Lanche;
import org.springframework.data.repository.CrudRepository;

public interface LancheRepository extends CrudRepository<Lanche, Long> {
}
