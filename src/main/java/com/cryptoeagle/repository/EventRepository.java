package com.cryptoeagle.repository;


import com.cryptoeagle.entity.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public interface EventRepository {

    List<Event> getAll();


    void saveAll(List<Event> events);

    void deleteAll();

}
