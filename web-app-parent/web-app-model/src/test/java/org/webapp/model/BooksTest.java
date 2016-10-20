package org.webapp.model;

import org.agileware.test.PropertiesTester;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class BooksTest {

    @Test
    public void coverage() throws Exception {
        PropertiesTester tester = new PropertiesTester();
        tester.testAll(Books.class);
    }

    @Test
    public void equalsTest() {

        Books b1 = new Books();
        Books b2 = new Books();

        assertThat(b1.equals(b1), is(true));
        assertThat(b1.equals(null), is(false));
        assertThat(b1.equals(b2), is(true));
        assertThat(b1.equals(new Object()), is(false));
    }

    @Test
    public void hashCodeTest() {

        Books b1 = new Books();
        List list = new ArrayList();
        Book book1 = new Book();
        book1.setId(1L);
        list.add(book1);
        b1.setBooks(list);

        Books b2 = new Books();
        List list2 = new ArrayList();
        Book book2 = new Book();
        book2.setId(2L);
        list2.add(book2);
        b2.setBooks(list2);

        assertThat(b1.hashCode(), is(not(b2.hashCode())));
    }

    @Test
    public void toStringTest() {

        Books b1 = new Books();
        assertThat(b1.toString().contains("Books"), is(true));
    }
}