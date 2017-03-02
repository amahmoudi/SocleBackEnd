package com.bakInfo.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.dao.daoJdbcSpring.RowUnmapper;
import com.bakInfo.model.User;
/**
 * 
 * @author amahmoudi
 *
 */
@Configuration
public class JdbcRepositoryConfig extends JdbcRepositoryConfigAbstract {

	
	@Override
	public GenericJdbcRepository<User, String> userRepository() {
		
		GenericJdbcRepository<User, String> genericJdbcRepository = new GenericJdbcRepository<User, String>(
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {

						return new User(rs.getLong("id"),rs.getString("user_email"), rs.getBoolean("user_enabled"),
								rs.getString("user_password"), rs.getBoolean("admin_enabled"));
					}
				}, new RowUnmapper<User>() {

					@Override
					public Map<String, Object> mapColumns(User t) {

						Map<String, Object> mapping = new LinkedHashMap<String, Object>();
						mapping.put("id", t.getId());
						mapping.put("user_email", t.getUserEmail());
						mapping.put("user_enabled", t.getUserEnabled());
						mapping.put("user_password", t.getUserPassword());
						mapping.put("admin_enabled", t.getAdminEnabled());
						return mapping;
					}
				}, "user", "id");
		
		return genericJdbcRepository;
	}
}
