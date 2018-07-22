package com.rjdesenvolvimento.imobiliaria.resources;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.dto.PessoaFisicaDto;
import com.rjdesenvolvimento.imobiliaria.services.clientes.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/clientes/pessoafisica")
public class ClienteResource {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        PessoaFisica pessoaFisica = pessoaFisicaService.buscar(id);
        return ResponseEntity.ok().body(pessoaFisica);
    }

    @GetMapping
    public ResponseEntity<List<PessoaFisicaDto>> buscarTodos() {
        List<PessoaFisica> pessoasFisicas = pessoaFisicaService.buscarTodos();
        List<PessoaFisicaDto> pessoasFisicasDtos = pessoasFisicas.stream().map(PessoaFisicaDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(pessoasFisicasDtos);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody PessoaFisicaDto pessoaFisicaDto) {
        PessoaFisica pessoaFisica = pessoaFisicaService.converteDeDto(pessoaFisicaDto);
        pessoaFisica = pessoaFisicaService.inserir(pessoaFisica);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaFisicaDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable PessoaFisica pessoaFisica, @PathVariable Integer id) {
        pessoaFisica.setId(id);
        pessoaFisica = pessoaFisicaService.atualizar(pessoaFisica);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        pessoaFisicaService.apagar(id);
        return  ResponseEntity.noContent().build();
    }
}
