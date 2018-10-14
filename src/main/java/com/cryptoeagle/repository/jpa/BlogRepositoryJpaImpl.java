package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class BlogRepositoryJpaImpl implements BlogRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(Blog blog) {
        em.remove(blog);
    }

    @Override
    public List<Blog> getAllByUser(int user_id) {
        return em.createNamedQuery(Blog.GET_ALL_BY_USER, Blog.class)
                .setParameter("user_id", user_id)
                .getResultList();
    }

    @Override
    @Transactional
    public Blog save(Blog blog, int user_id) {

        if (blog.isNew()) {
            User user = em.find(User.class, user_id);
            blog.setUser(user);
            em.persist(blog);
            return blog;
        } else {
            return em.merge(blog);
        }
    }

    @Override
    public void delete(int blog_id, int user_id) {
        em.createNamedQuery(Blog.DELETE)
                .setParameter("blog_id", blog_id)
                .setParameter("user_id", user_id)
                .executeUpdate();
    }

    @Override
    public Blog getByName(String name) {
        return em.createNamedQuery(Blog.GET_BY_NAME, Blog.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void deleteByName(String name) {
        em.createNamedQuery(Blog.DELETE_BY_NAME)
                .setParameter("name", name)
                .executeUpdate();
    }


    @Override
    public List<Blog> getAll() {
        return em.createNamedQuery(Blog.GET_ALL, Blog.class)
                .getResultList();
    }
}
