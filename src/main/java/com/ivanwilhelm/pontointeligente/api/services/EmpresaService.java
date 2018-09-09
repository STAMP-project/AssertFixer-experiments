package com.ivanwilhelm.pontointeligente.api.services;

import com.ivanwilhelm.pontointeligente.api.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    /**
     * Retorna uma empresa dado um CNPJ.
     *
     * @param cnpj CNPJ
     * @return {@link Optional<Empresa>}
     */
    Optional<Empresa> buscaPorCnpj(String cnpj);

    /**
     * Cadastra uma nova empresa na base de dados.
     *
     * @param empresa Empresa
     * @return {@link Empresa}
     */
    Empresa persistir(Empresa empresa);
}
