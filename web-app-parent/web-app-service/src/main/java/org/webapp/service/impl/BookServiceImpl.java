package org.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webapp.dao.hibernate.BookDao;
import org.webapp.model.Book;
import org.webapp.service.BookService;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, Long> implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public Book save(Book book) {
		return bookDao.save(book);
	}
	
}
