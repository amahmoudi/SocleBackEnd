package com.bakInfo.dao.daoJdbcSpring;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Persistable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 * 
 * @author amahmoudi
 *
 * @param <T>
 * @param <ID>
 */
public class GenericJdbcRepository<T extends Persistable<ID>, ID extends Serializable> extends AbstractJdbctemplateDao <T, ID>  {

	
	
	private GenericJdbcRepository(String tableName) {
		super(MAPPER, ROW_UNMAPPER, tableName);
	}

	public GenericJdbcRepository(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName, String idColumn) {
		super(rowMapper, rowUnmapper, tableName, idColumn);
	}

	public static final RowMapper MAPPER = new RowMapper() {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return null;
		}

		
	};

	public static final RowUnmapper ROW_UNMAPPER = new RowUnmapper() {
		@Override
		public Map<String, Object> mapColumns(Object comment) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			return mapping;
		}

		
	};

}