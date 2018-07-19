package com.brave.tradebravely.repository;

import com.brave.tradebravely.domain.Tax;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Spring Data MongoDB repository for the Tax entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaxRepository extends MongoRepository<Tax, String> {

    List<Tax> findAllByJournalIdIn(Collection<Long> journalIds);
}
