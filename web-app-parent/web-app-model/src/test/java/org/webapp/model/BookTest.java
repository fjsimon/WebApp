package org.webapp.model;

import org.agileware.test.PropertiesTester;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;


public class BookTest {

    @Test
    public void coverage() throws Exception {
        PropertiesTester tester = new PropertiesTester();
        tester.testAll(Book.class);
    }

    @Test
    public void equalsTest() {

        Book b1 = new Book();
        Book b2 = new Book();

        assertThat(b1.equals(b1), is(true));
        assertThat(b1.equals(null), is(false));
        assertThat(b1.equals(b2), is(true));
        assertThat(b1.equals(new Object()), is(false));
    }

    @Test
    public void hashCodeTest() {

        Book b1 = new Book();
        b1.setId(1L);

        Book b2 = new Book();
        b2.setId(2L);

        assertThat(b1.hashCode(), is(not(b2.hashCode())));
    }

    @Test
    public void toStringTest() {

        Book b1 = new Book();
        assertThat(b1.toString().contains("Book"), is(true));
    }
}