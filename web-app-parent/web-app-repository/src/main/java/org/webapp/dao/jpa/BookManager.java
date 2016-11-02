package org.webapp.dao.jpa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.model.Book;

@Component
@Transactional
public interface BookManager extends GenericRepository<Book, Long> {

    Book update(Book book);
}
