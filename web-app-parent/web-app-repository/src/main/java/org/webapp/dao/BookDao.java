package org.webapp.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.webapp.model.Book;

@Component
@Transactional
public interface BookDao extends GenericDao<Book, Long>{
	
	Book save(Book book);

}
