package com.bakInfo.dao.daoJPA;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao<T extends Serializable, S extends Serializable> {

	@PersistenceContext
	EntityManager entityManager;

	public T findOne(Class<T> className, S id) {
		return entityManager.find(className, id);
	}

	public List<T> findAll(Class<T> className) {
		return entityManager.createQuery("from " + className.getName()).getResultList();
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(Class<T> className, S entityId) {
		T entity = findOne(className, entityId);
		delete(entity);
	}
}
