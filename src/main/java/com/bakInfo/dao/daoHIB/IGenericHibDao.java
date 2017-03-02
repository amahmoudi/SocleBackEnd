package com.bakInfo.dao.daoHIB;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author amahmoudi
 *
 * @param <T>
 * @param <S>
 */
public interface IGenericHibDao<T extends Serializable, S extends Serializable> {

	T findOne(Class<T>  className,final S id);

	List<T> findAll(Class<T>  className);

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(Class<T>  className,final S entityId);
}