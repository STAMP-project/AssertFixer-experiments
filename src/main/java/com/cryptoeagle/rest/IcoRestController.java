package com.cryptoeagle.rest;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.exception.IcoNotFoundException;
import com.cryptoeagle.service.abst.IcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IcoRestController {


    @Autowired
    private IcoService icoService;

    @GetMapping(value = "/api/icos")
    public List<Ico> retrieveAllIcos() {
        return icoService.getAll();
    }



    @GetMapping(value = "/api/icos/{name}")
    public Ico getIcoWithData(@PathVariable String name) {
        return icoService.getByName(name);
    }

    @GetMapping(value = "/api/icos/upcoming")
    public List<Ico> retrieveUpcoming() {
        return icoService.getUpcoming();
    }

    @GetMapping(value = "/api/icos/finishied")
    public List<Ico> retrieveFinished() {
        return icoService.getFinished();
    }

    @GetMapping(value = "/api/icos/active")
    public List<Ico> retrieveActive() {
        return icoService.getActive();
    }



    @ExceptionHandler(value = IcoNotFoundException.class)
    public ResponseEntity<Object> icoNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
