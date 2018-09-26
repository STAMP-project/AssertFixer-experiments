package com.bindstone.portfolio.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface for CRUD Service.
 * All Services heritages have access to the methods
 *
 * @param <T> object
 */
public interface AbstractService<T> {

    Mono<T> getById(Long id);

    Flux<T> getAll();

    T save(T object);

    void delete(T object);

    void deleteById(Long id);
}
