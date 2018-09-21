package com.mbueno.lanchonete.repositories;

import com.mbueno.lanchonete.entities.Promocao;
import org.springframework.data.repository.CrudRepository;

public interface PromocaoRepository extends CrudRepository<Promocao, Long> {
}
