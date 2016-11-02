package org.webapp.dao.jpa;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.model.Book;
import org.webapp.model.Identity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class GenericRepositoryManager<T extends Identity, PK extends Serializable> implements GenericRepository<T, PK> {

    protected Class<T> persistentClass;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericRepositoryManager() {

        // TODO Check
        // this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public GenericRepositoryManager(final Class<T> persistentClass) {

        this.persistentClass = persistentClass;
    }

    @Override
    public List<T> findAll() {

        String modelClass = persistentClass.getSimpleName();
        return entityManager.createQuery("Select t from " + modelClass + " t").getResultList();
    }

    @Override
    public List<T> findAll(Sort sort) {

        // TODO
        return findAll();
    }

    @Override
    public List<T> findAll(Iterable<PK> iterable) {

        //TODO
        return findAll();
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> iterable) {

        List<S> result = new ArrayList<>();
        iterable.forEach(i -> result.add(save(i)));
        return result;
    }

    @Override
    public void flush() {

        entityManager.flush();
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {

        S result = entityManager.merge(s);
        flush();
        return result;
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {}

    @Override
    public void deleteAllInBatch() {}

    @Override
    public T getOne(PK pk) {

        return entityManager.find(persistentClass, pk);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {

        //TODO example
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {

        //TODO example & sort
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {

        //TODO pageable
        List list = entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
        return new PageImpl<T>(list, pageable, list.size());
    }

    @Override
    public <S extends T> S save(S s) {

        if (exists((PK) s.getId())) {
            // Updating
            return entityManager.merge(s);
        } else {
            // Creating
            entityManager.persist(s);
            return s;
        }
    }

    @Override
    public T findOne(PK pk) {

        return entityManager.find(persistentClass, pk);
    }

    @Override
    public boolean exists(PK pk) {

        Optional optional = Optional.ofNullable(findOne(pk));
        return optional.isPresent();
    }

    @Override
    public long count() {

        return findAll().size();
    }

    @Override
    public void delete(PK pk) {

        T t = findOne(pk);
        delete(t);
    }

    @Override
    public void delete(T t) {

        entityManager.remove(t);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {

        iterable.forEach(i -> delete(i));
    }

    /****************************************************************************************************/

    @Override
    public void deleteAll() {}

    @Override
    public <S extends T> S findOne(Example<S> example) {

        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {

        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {

        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {

        return false;
    }

    public EntityManager getEntityManager() {

        return entityManager;
    }
}
