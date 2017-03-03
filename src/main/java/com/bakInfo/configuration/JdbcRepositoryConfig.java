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
	public GenericJdbcRepository<User, Integer> userRepository() {
		
		GenericJdbcRepository<User, Integer> genericJdbcRepository = new GenericJdbcRepository<User, Integer>(
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {

						return new User(rs.getInt("ID"),rs.getString("SSO_ID"), rs.getString("PASSWORD"),
								rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getString("EMAIL"),rs.getInt("USER_PROFILE_ID"));
					}
				}, new RowUnmapper<User>() {

					@Override
					public Map<String, Object> mapColumns(User t) {

						Map<String, Object> mapping = new LinkedHashMap<String, Object>();
						mapping.put("id", t.getId());
						mapping.put("SSO_ID", t.getSsoId());
						mapping.put("PASSWORD", t.getPassword());
						mapping.put("FIRST_NAME", t.getFirstName());
						mapping.put("LAST_NAME", t.getLastName());
						mapping.put("EMAIL", t.getEmail());
						mapping.put("USER_PROFILE_ID", t.getIdProfil());
						return mapping;
					}
				}, "APP_USER", "id");
		
		return genericJdbcRepository;
	}
}
