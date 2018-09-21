package com.mbueno.lanchonete.controllers;

import com.mbueno.lanchonete.dtos.IngredienteDto;
import com.mbueno.lanchonete.entities.Pedido;
import com.mbueno.lanchonete.response.Response;
import com.mbueno.lanchonete.services.IngredienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/ingrediente")
@CrossOrigin(origins = "*")
public class IngredienteController {
    private static final Logger log = LoggerFactory.getLogger(Pedido.class);

    @Autowired
    private IngredienteService ingredienteService;

    public IngredienteController(){}

    @PostMapping
    public ResponseEntity<Response<IngredienteDto>> cadastrar(@Valid @RequestBody IngredienteDto ingredienteDto,
                                                              BindingResult result) throws NoSuchAlgorithmException {
        Response<IngredienteDto> response = new Response();

        return ResponseEntity.ok(response);
    }
}
