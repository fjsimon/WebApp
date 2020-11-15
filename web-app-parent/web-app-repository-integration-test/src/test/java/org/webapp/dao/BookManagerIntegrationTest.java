package org.webapp.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webapp.dao.config.AppConfig;
import org.webapp.dao.config.DbConfig;
import org.webapp.dao.jpa.BookManager;
import org.webapp.model.Book;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@Ignore
@SpringBootTest
@ActiveProfiles({"jpa", "test"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DbConfig.class})
public class BookManagerIntegrationTest {

    @Autowired
    private BookManager bookManager;

    @Test
    public void findAllAndGetTest(){

        List<Book> books = bookManager.findAll();
        assertThat(books, is(not(nullValue())));

        int random = ThreadLocalRandom.current().nextInt(0, books.size() + 1);
        Long id = books.get(random).getId();

        assertThat(bookManager.exists(id), is(true));

        Book randomBook = bookManager.getOne(id);
        assertThat(randomBook, is(not(nullValue())));

        random = ThreadLocalRandom.current().nextInt(0, books.size() + 1);
        id = books.get(random).getId();
        randomBook = bookManager.findOne(id);
        assertThat(randomBook, is(not(nullValue())));

    }

    @Test
    public void createAndSaveAndDeleteTest(){

        Book book = new Book();
//        long id = RandomUtils.nextLong();
        book.setId(1872635L);
        book.setAuthor("author");
        book.setDescription("description");
        book.setDownload("download");
        book.setImage("image url");
        book.setIsbn(12345678);
        book.setPublisher("publisher");
        book.setSubtitle("subtitle");
        book.setTitle("title");
        book.setYear(2100);

        Book createdBook = bookManager.save(book);
        long id = createdBook.getId();
        assertThat(id, is(not(nullValue())));

        createdBook.setTitle("new title");
        Book savedBook = bookManager.save(createdBook);
        assertThat(id, is(not(nullValue())));
        assertThat(savedBook.getTitle(), is("new title"));

        bookManager.delete(id);
        assertThat(bookManager.exists(id), is(false));

    }

}
