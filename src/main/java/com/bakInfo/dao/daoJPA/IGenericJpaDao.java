package com.bakInfo.dao.daoJPA;

import java.io.Serializable;
import java.util.List;

public interface IGenericJpaDao<T extends Serializable, S extends Serializable> {

	T findOne(Class<T> className,final S id);

	List<T> findAll(Class<T> className);

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(Class<T> className,final S entityId);
}