package com.bakInfo.configuration;

import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author amahmoudi
 *
 */
@Configuration
public class JdbcRepositoryConfig {

	
//	@Bean
//	public GenericJdbcRepository<User, Integer> userRepository() {
//		
//		GenericJdbcRepository<User, Integer> genericJdbcRepository = new GenericJdbcRepository<User, Integer>(
//				new RowMapper<User>() {
//
//					@Override
//					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//						return new User(rs.getInt("ID"),rs.getString("SSO_ID"), rs.getString("PASSWORD"),
//								rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getString("EMAIL"));
//					}
//				}, new RowUnmapper<User>() {
//
//					@Override
//					public Map<String, Object> mapColumns(User t) {
//
//						Map<String, Object> mapping = new LinkedHashMap<String, Object>();
//						mapping.put("id", t.getId());
//						mapping.put("SSO_ID", t.getSsoId());
//						mapping.put("PASSWORD", t.getPassword());
//						mapping.put("FIRST_NAME", t.getFirstName());
//						mapping.put("LAST_NAME", t.getLastName());
//						mapping.put("EMAIL", t.getEmail());
//						return mapping;
//					}
//				}, "APP_USER", "id");
//		
//		return genericJdbcRepository;
//	}
	
	
}
