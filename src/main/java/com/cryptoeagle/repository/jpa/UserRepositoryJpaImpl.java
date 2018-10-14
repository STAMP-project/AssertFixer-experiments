package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserRepositoryJpaImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public User saveAndUpdate(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public void delete(int id) {
        User user = get(id);
        em.remove(user);
    }

    @Override
    public User get(int id) {

        return em.createNamedQuery(User.GET_BY_ID, User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User getByName(String name) {

        return em.createNamedQuery(User.GET_BY_NAME, User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public User getByEmail(String email) {

        return em.createNamedQuery(User.GET_BY_EMAIL, User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.GET_ALL, User.class).getResultList();
    }

}
