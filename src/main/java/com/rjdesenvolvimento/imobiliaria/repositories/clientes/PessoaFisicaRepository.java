package com.rjdesenvolvimento.imobiliaria.repositories.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {
}
