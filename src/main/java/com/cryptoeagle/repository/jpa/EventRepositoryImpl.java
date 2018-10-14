package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Event;
import com.cryptoeagle.repository.EventRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Event> getAll() {
        return manager
                .createNamedQuery(Event.GET_ALL, Event.class)
                .getResultList();
    }

    @Override
    public void saveAll(List<Event> events) {
        for (Event e : events){
            manager.merge(e);
        }
    }

    @Override
    public void deleteAll() {
        manager.createQuery("DELETE FROM Event ");
    }
}
