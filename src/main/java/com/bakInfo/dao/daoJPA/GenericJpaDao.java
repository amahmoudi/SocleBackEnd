package com.bakInfo.dao.daoJPA;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericJpaDao< T extends Serializable , S extends Serializable> extends AbstractJpaDao< T , S> implements IGenericJpaDao< T , S>{


}
