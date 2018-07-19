package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.Tax;
import com.brave.tradebravely.repository.TaxRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Tax.
 */
@Service
public class TaxService {

    private final Logger log = LoggerFactory.getLogger(TaxService.class);

    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    /**
     * Save a tax.
     *
     * @param tax the entity to save
     * @return the persisted entity
     */
    public Tax save(Tax tax) {
        log.debug("Request to save Tax : {}", tax);        return taxRepository.save(tax);
    }

    /**
     * Get all the taxes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    public Page<Tax> findAll(Pageable pageable) {
        log.debug("Request to get all Taxes");
        return taxRepository.findAll(pageable);
    }


    /**
     * Get one tax by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Optional<Tax> findOne(String id) {
        log.debug("Request to get Tax : {}", id);
        return taxRepository.findById(id);
    }

    /**
     * Delete the tax by id.
     *
     * @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Tax : {}", id);
        taxRepository.deleteById(id);
    }

    public void persistIfNew(List<Tax> taxes) {
        final Set<Long> journalIds = taxes.stream()
            .map(Tax::getJournalId).collect(Collectors.toSet());
        final Set<Long> existingJournalIds = taxRepository.findAllByJournalIdIn(journalIds)
            .stream().map(Tax::getJournalId).collect(Collectors.toSet());

        final List<Tax> newTaxes = taxes.stream()
            .filter(t -> !existingJournalIds.contains(t.getJournalId()))
            .collect(Collectors.toList());

        if (!newTaxes.isEmpty()) {
            log.info("Adding {} new taxes for character {}.", newTaxes.size(), taxes.get(0).getCharacterId());
            taxRepository.saveAll(newTaxes);
        }
    }
}
