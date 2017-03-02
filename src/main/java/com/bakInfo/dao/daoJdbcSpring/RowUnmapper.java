package com.bakInfo.dao.daoJdbcSpring;

import java.util.Map;

public interface RowUnmapper<T> {
	Map<String, Object> mapColumns(T t);
}

