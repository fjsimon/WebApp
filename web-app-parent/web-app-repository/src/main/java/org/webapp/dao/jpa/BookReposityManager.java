package org.webapp.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.dao.BookDao;
import org.webapp.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class BookReposityManager extends GenericRepositoryManager<Book, Long> implements BookManager {

    @PersistenceContext
    private EntityManager entityManager;

    public BookReposityManager() {

        super(Book.class);
    }

//    @Override
//    public Book save(Book b) {
//        return entityManager.merge(b);
//    }

}
