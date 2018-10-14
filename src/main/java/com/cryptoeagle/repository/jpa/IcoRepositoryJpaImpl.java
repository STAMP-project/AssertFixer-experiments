package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.IcoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;


@Repository
@Transactional
public class IcoRepositoryJpaImpl implements IcoRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(Ico ico) {
        em.remove(ico);
    }

    @Override
    public List<Ico> getAll() {
        return em.createNamedQuery(Ico.GET_ALL, Ico.class)
                .setMaxResults(30)
                .getResultList();
    }

    @Override
    public void save(Ico ico) {
        if (ico.isNew())
            em.persist(ico);
        else em.merge(ico);

    }

    @Override
    @Transactional
    public void save(List<Ico> icos) {
        for (Ico ico : icos) {
            em.persist(ico);
        }
    }

    @Override
    public List<Ico> getActive() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return em.createNamedQuery(Ico.GET_ACTIVE, Ico.class)
                .setParameter("date", localDateTime)
                .getResultList();
    }

    @Override
    public List<Ico> getUpcoming() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return em.createNamedQuery(Ico.GET_UPCOMING, Ico.class)
                .setParameter("date", localDateTime)
                .getResultList();
    }

    @Override
    public List<Ico> getFinished() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return em.createNamedQuery(Ico.GET_ENDED, Ico.class)
                .setParameter("date", localDateTime)
                .getResultList();
    }


    @Override
    @Transactional
    public Ico getById(int id) {
        return em.createNamedQuery(Ico.GET_BY_ID, Ico.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Ico getByName(String name) {
        return em.createNamedQuery(Ico.GET_BY_NAME, Ico.class)
                .setParameter("name", name)
                .getSingleResult();

    }

    @Override
    public List<Ico> getByNames(List<String> names) {
        return em.createNamedQuery(Ico.GET_BY_NAMES, Ico.class)
                .setParameter("names", names)
                .getResultList();
    }
}


