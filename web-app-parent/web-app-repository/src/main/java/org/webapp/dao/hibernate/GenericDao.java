package org.webapp.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface GenericDao<T, PK extends Serializable> {

	List<T> getAll();
	List<T> getAllDistinct();

	T get(Class<T> type, PK id);
	boolean exits(Class<T> type, PK id);
	T save(T o);
	void delete(T o);
}
