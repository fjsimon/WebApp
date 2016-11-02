package org.webapp.service;

import org.springframework.stereotype.Component;
import org.webapp.model.Book;


@Component
public interface BookService extends GenericService<Book, Long> {

	Book save(Book book);
	
}
