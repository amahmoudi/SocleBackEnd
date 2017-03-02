package com.bakInfo.dao.daoHIB;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author amahmoudi
 *
 * @param <T>
 * @param <S>
 */
public abstract class AbstractHibernateDao< T extends Serializable , S extends Serializable> {
	 
	   @Autowired
	   SessionFactory sessionFactory;
	 
	   public T findOne(Class<T>   className, S id ){
	      final Session currentSession = getCurrentSession();
		return (T) currentSession.get( className, id );
	   }
	   public List< T > findAll(Class<T> className){
	      final Session currentSession = getCurrentSession();
		return currentSession.createQuery( "from " +  className.getName() ).list();
	   }
	 
	   public void create( T entity ){
	      final Session currentSession = getCurrentSession();
		currentSession.persist( entity );
	   }
	 
	   public void update( T entity ){
	      final Session currentSession = getCurrentSession();
		currentSession.merge( entity );
	   }
	 
	   public void delete( T entity ){
	      final Session currentSession = getCurrentSession();
		currentSession.delete( entity );
	   }
	   public void deleteById(Class<T>  className, S entityId ) {
	      T entity = findOne(className, entityId );
	      delete( entity );
	   }
	 
	   protected final Session getCurrentSession() {
	      return sessionFactory.getCurrentSession();
	   }
	}