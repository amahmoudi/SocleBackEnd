package com.bakInfo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bakInfo.configuration.AppConfiguration;
import com.bakInfo.dao.daoJdbcSpring.GenericJdbcRepository;
import com.bakInfo.model.User;
import com.bakInfo.service.IGenericService;

@SpringBootApplication
public class BackEndApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
		
		AbstractApplicationContext context  = new AnnotationConfigApplicationContext(AppConfiguration.class);
		IGenericService<User,String> service = (IGenericService<User,String>) context.getBean("genericService");
		GenericJdbcRepository<User, String> service2 = (GenericJdbcRepository<User, String>) context.getBean("userRepository");
		
		
		
		
		final User entity = new User("baki.mahmoudi@bluescale.com",true,"password@123",true);
		
		service2.save(entity);
//		service.create(entity);
//		final User findAll = service.findOne(User.class,"baki.mahmoudi@bluescale.com");
//		service.deleteById(User.class, "baki.mahmoudi@bluescale.com");
		
		final List<User> findAll = service.findAll(User.class);
		System.out.println("*********************** : " + findAll);
		
		//when
		
		
		
		
		
		
	}
}