package org.webapp.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.webapp.model.Book;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryDaoTest {

    @InjectMocks
    private BookDaoHibernate testee;

    @Mock
    private SessionFactory sessionFactory;

    @Test
    public void save(){

        Session session = mock(Session.class);
        Book book = new Book();

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.save(book)).thenReturn("id");
        when(session.get(eq(Book.class), eq("id"))).thenReturn(book);

        testee.save(book);

        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).save(book);
        verify(session, times(1)).get(eq(Book.class), eq("id"));
    }
}
