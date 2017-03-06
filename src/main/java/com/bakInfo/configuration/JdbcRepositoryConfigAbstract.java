package com.bakInfo.configuration;

import org.springframework.context.annotation.Bean;

import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.model.PersistentLogin;
import com.bakInfo.model.User;
import com.bakInfo.model.UserProfile;

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
	
	@Bean
	public GenericJdbcRepository<PersistentLogin, Integer> PersistentLoginRepository() {
		return new GenericJdbcRepository(null, null, "PERSISTENT_LOGINS", "id");
	}
	
	@Bean
	public GenericJdbcRepository<UserProfile, Integer> UserProfileRepository() {
		return new GenericJdbcRepository(null, null, "USER_PROFILE", "id");
	}
	
	
	
	
}
