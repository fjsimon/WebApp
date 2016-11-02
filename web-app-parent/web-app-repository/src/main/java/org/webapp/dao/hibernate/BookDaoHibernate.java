package org.webapp.dao.hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.model.Book;

@Repository
@Transactional
public class BookDaoHibernate extends GenericDaoHibernate<Book, Long> implements BookDao{


	public BookDaoHibernate() {

		super(Book.class);
	}

	public Book save(Book book) {
		Session session = getSessionFactory().getCurrentSession();
//		session.save(book);
		return (Book) session.get(Book.class, session.save(book));
	}
}
