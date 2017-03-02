package com.bakInfo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bakInfo.dao.daoHIB.IGenericHibDao;

@Service("genericService")
@Transactional(rollbackFor = Exception.class)
class GenericService<T extends Serializable, S extends Serializable>  implements IGenericService<T, S> {

	private IGenericHibDao<T,S> dao;

	@Autowired
	public void setDao(IGenericHibDao<T,S> daoToSet) {
		this.dao = daoToSet;
	}

	@Override
	public T findOne(Class<T>  className, S id) {
		return dao.findOne(className, id);
	}

	@Override
	public List<T> findAll(Class<T>  className) {
		return dao.findAll(className);
	}

	@Override
	public void create(T entity) {
		dao.create(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteById(Class<T>  className, S entityId) {
		dao.deleteById(className, entityId);
	}

}