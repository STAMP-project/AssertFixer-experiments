package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.repository.TransactionRepository;
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
 * Service Implementation for managing Transaction.
 */
@Service
public class TransactionService {

    private final Logger log = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Save a transaction.
     *
     * @param transaction the entity to save
     * @return the persisted entity
     */
    public Transaction save(Transaction transaction) {
        log.debug("Request to save Transaction : {}", transaction);        return transactionRepository.save(transaction);
    }

    /**
     * Get all the transactions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    public Page<Transaction> findAll(Pageable pageable) {
        log.debug("Request to get all Transactions");
        return transactionRepository.findAll(pageable);
    }


    /**
     * Get one transaction by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Optional<Transaction> findOne(String id) {
        log.debug("Request to get Transaction : {}", id);
        return transactionRepository.findById(id);
    }

    /**
     * Delete the transaction by id.
     *
     * @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Transaction : {}", id);
        transactionRepository.deleteById(id);
    }

    public void persistIfNew(List<Transaction> transactions) {
        final Set<Long> transactionIds = transactions.stream()
            .map(Transaction::getTransactionId).collect(Collectors.toSet());
        final Set<Long> existingTransactionIds = transactionRepository.findAllByTransactionIdIn(transactionIds)
            .stream().map(Transaction::getTransactionId).collect(Collectors.toSet());

        final List<Transaction> newTransactions = transactions.stream()
            .filter(t -> !existingTransactionIds.contains(t.getTransactionId()))
            .collect(Collectors.toList());

        if (!newTransactions.isEmpty()) {
            log.info("Adding {} new transactions for character {}.", newTransactions.size(), transactions.get(0).getCharacterId());
            transactionRepository.saveAll(newTransactions);
        }
    }
}
