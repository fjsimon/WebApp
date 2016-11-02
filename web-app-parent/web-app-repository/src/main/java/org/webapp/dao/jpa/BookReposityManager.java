package org.webapp.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.model.Book;

@Repository
@Transactional
public class BookReposityManager extends GenericRepositoryManager<Book, Long> implements BookManager {


    public BookReposityManager() {

        super(Book.class);
    }

    @Override
    public Book update(Book b) {

        return getEntityManager().merge(b);
    }

}
