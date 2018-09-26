package com.bindstone.portfolio.service.impl;

import com.bindstone.portfolio.annotations.Auditable;
import com.bindstone.portfolio.exceptions.Messages;
import com.bindstone.portfolio.service.AbstractService;
import com.bindstone.portfolio.validator.DefaultObjectServiceValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * General Abstract CRUD Service
 *
 * @param <T> Generic Object
 */
@Slf4j
public abstract class AbstractServiceImpl<T> implements AbstractService<T> {

    private CrudRepository crudRepository;
    private DefaultObjectServiceValidator validator;

    /**
     * Constructor
     *
     * @param crudRepository CRUD Repository
     * @param validator      validator
     */
    public AbstractServiceImpl(CrudRepository crudRepository, DefaultObjectServiceValidator validator) {
        this.crudRepository = crudRepository;
        this.validator = validator;
    }

    /**
     * Get By ID
     * @param id ID
     * @return Reactive Mono Object
     */
    @Override
    @Transactional(readOnly = true)
    public Mono<T> getById(Long id) {
        log.debug("find by id [{}]", id);
        return Mono.justOrEmpty(crudRepository.findById(id));
    }

    /**
     * Get All
     * @return Reactive Flux list of Objects
     */
    @Override
    @Transactional(readOnly = true)
    public Flux<T> getAll() {
        log.debug("Find all");
        return Flux.fromIterable(crudRepository.findAll());
    }

    /**
     * Save Object
     * @param object object
     * @return object (in case of create with new ID)
     */
    @Override
    @Transactional
    @Auditable(text = "AUDIT POINT: SAVE")
    public T save(T object) {
        validator.onSave(object);
        log.debug("Save object [{}]", object);
        return (T) crudRepository.save(object);
    }

    /**
     * Delete object
     * @param object object
     */
    @Override
    @Transactional
    public void delete(T object) {
        log.debug("Delete object [{}]", object);
        crudRepository.delete(object);
    }

    /**
     * Delete object by id
     *
     * @param id object
     */
    @Override
    @Transactional
    @Auditable(text = "AUDIT POINT: DELETE")
    public void deleteById(Long id) {
        log.debug("Delete object [{}]", id);
        T byId = this.getById(id).block();
        Validate.notNull(byId, Messages.DELETE_ID_WITHOUT_OBJECT.message(), Messages.DELETE_ID_WITHOUT_OBJECT);
        crudRepository.delete(byId);
    }
}
