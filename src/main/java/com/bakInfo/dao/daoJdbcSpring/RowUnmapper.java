package com.bakInfo.dao.daoJdbcSpring;

import java.util.Map;
/**
 * 
 * @author amahmoudi
 *
 * @param <T>
 */
public interface RowUnmapper<T> {
	Map<String, Object> mapColumns(T t);
}

