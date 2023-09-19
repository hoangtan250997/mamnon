package com.assignment.dao;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
/**
 * Contract for a generic DAO.
 *
 * @param <E> - Entity type parameter.
 */

@RequiredArgsConstructor
@ApplicationScoped
public abstract class BaseDAO<E> {

    private final Class<E> entityClass;
    @PersistenceContext(name = "mamnon")
     EntityManager em;

    public E create(E entity) {
        em.persist(entity);
        return entity;
    }

    public E update(E entity) {
        E updatedEntity = em.merge(entity);
        em.flush();
        return updatedEntity;
    }

    public Optional<E> findById(Long id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }

    public List<E> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(entityClass);
        Root<E> root = cq.from(entityClass);
        cq.select(root);

        return em.createQuery(cq).getResultList();
    }
}