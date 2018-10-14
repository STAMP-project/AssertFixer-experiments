package com.cryptoeagle.rest;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.ItemNotFoundException;
import com.cryptoeagle.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemRestController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/api/items")
    public List<Item> getItems() {
        return itemService.getAll();
    }

    @RequestMapping(value = "/api/items/{name}")
    public List<Item> getItemsBySource(@PathVariable String name) {
        List<Item> items =   itemService.getBySource(name);
        return itemService.getBySource(name);
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<Object> itemNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
