package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.repository.WhiteListRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class WhiteListRepositoryJpaImpl implements WhiteListRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<WhiteList> getAll() {
      return    em.createNamedQuery(WhiteList.GET_ALL, WhiteList.class)
              .getResultList();
    }

    @Override
    @Transactional
    public void save(List<WhiteList> whiteLists) {
        for (WhiteList whiteList : whiteLists){
            em.persist(whiteList);
        }
    }
}
