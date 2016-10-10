package org.webapp.dao.hibernate;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webapp.dao.BookDao;
import org.webapp.dao.config.AppConfig;
import org.webapp.dao.config.DbConfig;
import org.webapp.model.Book;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@ActiveProfiles({"hibernate", "test"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DbConfig.class})
public class BookDaoTest {

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

        Book book = bookDao.get(Book.class, Long.valueOf(123456));
        assertThat(book, is(not(nullValue())));
    }

    @Test
    public void exists(){
        assertThat(bookDao.exits(Book.class, Long.valueOf(RandomStringUtils.randomNumeric(10))), is(false));
    }
}