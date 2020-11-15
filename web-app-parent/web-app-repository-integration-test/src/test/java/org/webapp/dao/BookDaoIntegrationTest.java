package org.webapp.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webapp.dao.config.AppConfig;
import org.webapp.dao.config.DbConfig;
import org.webapp.dao.hibernate.BookDao;
import org.webapp.model.Book;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@Ignore
@SpringBootTest
@ActiveProfiles({"hibernate", "test"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DbConfig.class})
public class BookDaoIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookDao bookDao;

    @Test
    public void selectBook(){

//        Book book = new Book();
//        book.setAuthor("Fran");
//        book.setDescription("Description");
//        book.setId(123456);
//        book.setDownload("download");
//        book.setImage("image url");
//        book.setIsbn(12345678);
//        book.setPublisher("publisher");
//        book.setSubtitle("subtitle");
//        book.setTitle("title");
//        book.setYear(2000);
//
//        bookDao.save(book);

        List<Book> books = bookDao.getAll();

        assertThat(books, is(not(nullValue())));
    }

    @Test
    public void getBook(){

        List<Book> books = bookDao.getAll();
        int random = ThreadLocalRandom.current().nextInt(0, books.size() + 1);
        Long id = books.get(random).getId();

        Book book = bookDao.get(Book.class, id);
        assertThat(book, is(not(nullValue())));
    }

    @Test
    public void exists(){
        assertThat(bookDao.exits(Book.class, Long.valueOf(RandomStringUtils.randomNumeric(10))), is(false));
    }

}
