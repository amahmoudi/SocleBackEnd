package com.bakInfo.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.dao.daoJdbcSpring.RowUnmapper;
import com.bakInfo.model.PersistentLogin;
import com.bakInfo.model.User;
import com.bakInfo.model.UserProfile;
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
	
	@Override
	public GenericJdbcRepository<PersistentLogin, Integer> PersistentLoginRepository() {
		GenericJdbcRepository<PersistentLogin, Integer> genericJdbcRepository = new GenericJdbcRepository<PersistentLogin, Integer>(new RowMapper<PersistentLogin>() {

			@Override
			public PersistentLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new PersistentLogin(rs.getInt("id"),rs.getString("series"), rs.getString("USERNAME"), rs.getString("TOKEN"), rs.getDate("last_used"));
			}

			
		}, new RowUnmapper<PersistentLogin>() {

			@Override
			public Map<String, Object> mapColumns(PersistentLogin t) {

				Map<String, Object> mapping = new LinkedHashMap<String, Object>();
				mapping.put("id", t.getId());
				mapping.put("series", t.getSeries());
				mapping.put("USERNAME", t.getUsername());
				mapping.put("TOKEN", t.getToken());
				mapping.put("last_used", t.getLast_used());
				return mapping;
			}

			
		}, "PERSISTENT_LOGINS", "id");
		return genericJdbcRepository;
	}
	
	@Override
	public GenericJdbcRepository<UserProfile, Integer> UserProfileRepository() {
		GenericJdbcRepository<UserProfile, Integer> genericJdbcRepository = new GenericJdbcRepository<>(new RowMapper<UserProfile>() {

			@Override
			public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new UserProfile(rs.getInt("id"), rs.getString("type"));
			}

			
		}, new RowUnmapper<UserProfile>() {

			@Override
			public Map<String, Object> mapColumns(UserProfile t) {
				Map<String, Object> mapping = new LinkedHashMap<String, Object>();
				mapping.put("id", t.getId());
				mapping.put("type", t.getType());
				return mapping;
			}
			
		}, "USER_PROFILE", "id");
		return genericJdbcRepository;
	}
}
