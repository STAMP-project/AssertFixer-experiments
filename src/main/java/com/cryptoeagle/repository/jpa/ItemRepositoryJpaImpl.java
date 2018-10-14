package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ItemRepositoryJpaImpl implements ItemRepository {

    @PersistenceContext
    EntityManager em;



    @Override
    public List<String> getSources() {
        return em.createNamedQuery(Item.GET_ALL_SOURCE, String.class)
                .getResultList();
    }


    @Override
    @Transactional
    public List<Item> getBySource(String source) {
        return em.createNamedQuery(Item.GET_BY_SOURCE, Item.class)
                .setParameter("source", source)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Item> getAll() {
        return em.createNamedQuery(Item.GET_ALL, Item.class)
                .getResultList();
    }
}
