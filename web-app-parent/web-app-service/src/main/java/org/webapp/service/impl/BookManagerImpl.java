package org.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webapp.dao.BookDao;
import org.webapp.model.Book;
import org.webapp.service.BookManager;

@Service
public class BookManagerImpl extends GenericManagerImpl<Book, Long> implements BookManager {

	@Autowired
	private BookDao bookDao;
	
	public Book save(Book book) {
		return bookDao.save(book);
	}
	
}
