package com.bakInfo.dao.daoHIB;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author amahmoudi
 *
 * @param <T>
 * @param <S>
 */
@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericHibernateDao< T extends Serializable, S extends Serializable > extends AbstractHibernateDao< T, S > implements IGenericHibDao< T , S>{
   
	
}