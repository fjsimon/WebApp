package org.webapp.dao.hibernate;

import java.io.Serializable;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {

	protected Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;

	public GenericDaoHibernate(){

	}

	public GenericDaoHibernate(final Class<T> persistentClass){

		this.persistentClass = persistentClass;
	}

	public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory){
		this.persistentClass = persistentClass;
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	@Autowired
	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	

	public List<T> getAll(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	public List<T> getAllDistinct(){
		Collection<T> result = new LinkedHashSet<T>(getAll());
		return new ArrayList<T>(result);
	}

	@Override
	public T get(final Class<T> type, final PK id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	@Override
	public boolean exits(final Class<T> type, final PK id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().get(type, id)).isPresent();
	}

	@Override
	public T save(T o) {
		return (T) sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void delete(final T o){
		sessionFactory.getCurrentSession().delete(o);
	}

	
}
