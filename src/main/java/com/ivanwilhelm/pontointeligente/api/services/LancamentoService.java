package com.ivanwilhelm.pontointeligente.api.services;

import com.ivanwilhelm.pontointeligente.api.entities.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface LancamentoService {
    /**
     * Retorna uma lista paginada de lançamentos de um determinado funcionário.
     *
     * @param funcionarioId Funcionário
     * @param pageRequest Paginação
     * @return {@link Page<Lancamento>}
     */
    Page<Lancamento> buscarPorFuncionario(Long funcionarioId, PageRequest pageRequest);

    /**
     * Retorna um lançamento na base de dados.
     *
     * @param id ID fo lançamento.
     * @return {@link Optional<Lancamento>}
     */
    Optional<Lancamento> buscarPorId(Long id);

    /**
     * Persiste um lançamento na base de dados.
     *
     * @param lancamento Lançamento
     * @return {@link Lancamento}
     */
    Lancamento persistir(Lancamento lancamento);

    /**
     * Remove um lançamento da base de dados.
     * @param id ID do lançamento.
     */
    void remover(Long id);
}
