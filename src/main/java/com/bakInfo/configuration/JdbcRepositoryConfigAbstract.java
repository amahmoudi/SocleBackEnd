package com.bakInfo.configuration;

import org.springframework.context.annotation.Bean;

import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.model.User;


public abstract class JdbcRepositoryConfigAbstract {
	@Bean
	public GenericJdbcRepository<User, String> userRepository() {
		return new GenericJdbcRepository<>(null, null, "user", "id");
	}
	
}
