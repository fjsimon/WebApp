package org.webapp.dao.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.webapp.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryManagerTest {

    @InjectMocks
    private BookReposityManager testee;

    @Mock
    private EntityManager entityManager;

    @Test
    public void update() {

        Book book = new Book();
        when(entityManager.merge(book)).thenReturn(new Book());
        assertThat(testee.update(book), is(not(nullValue())));
        verify(entityManager, times(1)).merge(book);
    }

    @Test
    public void findAll() {

        Query q = mock(Query.class);
        when(q.getResultList()).thenReturn(new ArrayList());
        when(entityManager.createQuery(anyString())).thenReturn(q);

        assertThat(testee.findAll().isEmpty(), is(true));
        verify(entityManager, times(1)).createQuery(anyString());
    }

    @Test
    public void getOne() {

        when(entityManager.find(any(), anyObject())).thenReturn(new Book());

        assertThat(testee.getOne(1l), is(not(nullValue())));

        verify(entityManager, times(1)).find(any(), any());
    }

    @Test
    public void saveAndFlush(){

        when(entityManager.merge(any())).thenReturn(new Book());

        assertThat(testee.saveAndFlush(new Book()), is(not(nullValue())));

        verify(entityManager, times(1)).merge(any());
        verify(entityManager, times(1)).flush();
        verifyNoMoreInteractions(entityManager);
    }

    @Test
    public void saveExistingBook() {

        Book existingBook = new Book();
        existingBook.setId(1l);

        when(entityManager.find(eq(Book.class), eq(1l))).thenReturn(existingBook);
        when(entityManager.merge(eq(existingBook))).thenReturn(existingBook);

        assertThat(testee.save(existingBook), is(not(nullValue())));

        verify(entityManager, times(1)).merge(eq(existingBook));
        verify(entityManager, times(1)).find(eq(Book.class), eq(1l));
        verifyNoMoreInteractions(entityManager);
    }

    @Test
    public void saveNewBook() {

        Book newBook = new Book();

        when(entityManager.find(eq(Book.class), any())).thenReturn(null);

        assertThat(testee.save(newBook), is(not(nullValue())));

        verify(entityManager, times(1)).persist(any());
        verify(entityManager, times(1)).find(eq(Book.class), any());
        verifyNoMoreInteractions(entityManager);
    }

    @Test
    public void saveIterable() {

        Book b1 = new Book();
        Book b2 = new Book();
        List books = Arrays.asList(b1, b2);

        when(entityManager.find(eq(Book.class), any())).thenReturn(b1).thenReturn(b2);
        when(entityManager.merge(any())).thenReturn(b1).thenReturn(b2);

        assertThat(testee.save(books), is(notNullValue()));


        verify(entityManager, times(2)).merge(any());
        verify(entityManager, times(2)).find(eq(Book.class), any());
        verifyNoMoreInteractions(entityManager);
    }

    @Test
    public void flush() {

        testee.flush();
        verify(entityManager, times(1)).flush();
    }
}
