package com.bakInfo.dao.daoJdbcSpring;

import java.util.Map;
/**
 * 
 * @author amahmoudi
 *
 * @param <T>
 */
public class MissingRowUnmapper<T> implements RowUnmapper<T> {
	@Override
	public Map<String, Object> mapColumns(Object o) {
		throw new UnsupportedOperationException("This repository is read-only, it can't store or update entities");
	}
}
