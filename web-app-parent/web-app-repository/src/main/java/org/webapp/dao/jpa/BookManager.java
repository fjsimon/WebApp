package org.webapp.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.webapp.dao.BookDao;
import org.webapp.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookManager extends GenericManager<Book, Long> implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookManager() {

        super(Book.class);
    }

    @Override
    public Book save(Book b) {
        return entityManager.merge(b);
    }

}
