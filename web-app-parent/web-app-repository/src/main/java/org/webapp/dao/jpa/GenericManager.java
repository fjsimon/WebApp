package org.webapp.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.*;

@Repository
@Transactional
public class GenericManager<T, PK extends Serializable> implements GenericDao<T, PK> {

    protected Class<T> persistentClass;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericManager(){}

    public GenericManager(final Class<T> persistentClass){

        this.persistentClass = persistentClass;
    }

    public List<T> getAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    public List<T> getAllDistinct(){
        Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
    }

    @Override
    public T get(final Class<T> type, final PK id) {

        return (T) entityManager.find(type, id);
    }

    @Override
    public boolean exits(final Class<T> type, final PK id) {

        return Optional.ofNullable(entityManager.find(type, id)).isPresent();
    }

    @Override
    public T save(T o) {

        return (T) entityManager.merge(o);
    }

    @Override
    public void delete(final T o) {

        entityManager.remove(o);
    }



}
