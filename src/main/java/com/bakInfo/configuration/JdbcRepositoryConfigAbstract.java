package com.bakInfo.configuration;

import org.springframework.context.annotation.Bean;

import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.model.User;

/**
 * 
 * @author amahmoudi
 *
 */
public abstract class JdbcRepositoryConfigAbstract {
	@Bean
	public GenericJdbcRepository<User, Integer> userRepository() {
		return new GenericJdbcRepository(null, null, "APP_USER", "id");
	}
	
}
