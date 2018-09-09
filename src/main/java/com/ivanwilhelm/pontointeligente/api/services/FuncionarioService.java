package com.ivanwilhelm.pontointeligente.api.services;

import com.ivanwilhelm.pontointeligente.api.entities.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    /**
     * Persiste um funcionário na base de dados.
     *
     * @param funcionario Funcionário
     * @return {@link Funcionario}
     */
    Funcionario persistir(Funcionario funcionario);

    /**
     * Busca e retorna um funcionário dado um CPF.
     *
     * @param cpf CPF.
     * @return {@link Optional<Funcionario>}
     */
    Optional<Funcionario> buscarPorCpf(String cpf);

    /**
     * Busca e retorna um funcionário dado um e-mail.
     *
     * @param email E-mail.
     * @return {@link Optional<Funcionario>}
     */
    Optional<Funcionario> buscarPorEmail(String email);

    /**
     * Busca e retorna um funcionário dado um ID.
     *
     * @param id ID.
     * @return {@link Optional<Funcionario>}
     */
    Optional<Funcionario> buscarPorId(Long id);
}
