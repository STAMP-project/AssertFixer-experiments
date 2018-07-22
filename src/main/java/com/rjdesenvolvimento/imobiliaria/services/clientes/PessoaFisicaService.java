package com.rjdesenvolvimento.imobiliaria.services.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.dto.PessoaFisicaDto;
import com.rjdesenvolvimento.imobiliaria.repositories.clientes.PessoaFisicaRepository;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ExcecaoDeIntefridadeDeDados;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ExcecaoObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public PessoaFisica buscar(Integer id) {
        Optional<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findById(id);
        return pessoaFisica.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("Objeto não encontrado! Id: "
                + id + ", tipo: " + PessoaFisica.class.getName()));
    }

    public List<PessoaFisica> buscarTodos() {
        return pessoaFisicaRepository.findAll();
    }

    public PessoaFisica inserir(PessoaFisica pessoaFisica) {
        pessoaFisica.setId(null);
        return pessoaFisicaRepository.save(pessoaFisica);
    }


    public PessoaFisica atualizar(PessoaFisica pessoaFisica) {
        buscar(pessoaFisica.getId());
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public void apagar(Integer id) {
        buscar(id);
        try {
            pessoaFisicaRepository.deleteById(id);
        } catch (DataIntegrityViolationException excecao) {
            throw new ExcecaoDeIntefridadeDeDados("Não é possivel excluir um cliente atrelado em outra tabela");
        }
    }

    public PessoaFisica converteDeDto(PessoaFisicaDto pessoaFisicaDto) {
        PessoaFisica pessoaFisica = new PessoaFisica(pessoaFisicaDto.getNome(), pessoaFisicaDto.getCpf(),
                pessoaFisicaDto.getRg(), pessoaFisicaDto.getDataDeNascimento(), null);

        return pessoaFisica;
    }
}
