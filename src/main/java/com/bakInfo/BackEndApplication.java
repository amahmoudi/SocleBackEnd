package com.bakInfo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bakInfo.configuration.AppConfiguration;
import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.model.PersistentLogin;
import com.bakInfo.model.User;
import com.bakInfo.model.UserProfile;
import com.bakInfo.service.IGenericService;
/**
 * 
 * @author amahmoudi
 *
 */
@SpringBootApplication
public class BackEndApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
		
		AbstractApplicationContext context  = new AnnotationConfigApplicationContext(AppConfiguration.class);
		IGenericService<User,String> service = (IGenericService<User,String>) context.getBean("genericService");
		GenericJdbcRepository<User, Integer> service2 = (GenericJdbcRepository<User, Integer>) context.getBean("userRepository");
		GenericJdbcRepository<PersistentLogin, Integer> service3 = (GenericJdbcRepository<PersistentLogin, Integer>) context.getBean("PersistentLoginRepository");
		GenericJdbcRepository<UserProfile, Integer> service4 = (GenericJdbcRepository<UserProfile, Integer>) context.getBean("UserProfileRepository");
		
		
		UserProfile prf= new UserProfile("ADMIN");
		
		service4.save(prf);
		
		PersistentLogin prs= new PersistentLogin("abdelbaki.mahmoudi@gmail.com","baki mahmoudi", "azerty@123", new Date());
		
		service3.save(prs);
		
		final User entity = new User("abdelbaki.mahmoudi@gmail.com", "password@123", "mahmoudi", "abdelbaki", "abdelbaki.mahmoudi@gmail.com", 1);
		
		service2.save(entity);
		
		
		final List<User> findAll = service.findAll(User.class);
		System.out.println("*********************** : " + findAll);
		
	}
}
