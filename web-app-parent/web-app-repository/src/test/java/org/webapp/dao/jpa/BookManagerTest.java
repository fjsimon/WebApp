package org.webapp.dao.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webapp.dao.config.AppConfig;
import org.webapp.dao.config.DbConfig;
import org.webapp.model.Book;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

@ActiveProfiles({"jpa", "test"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DbConfig.class})
public class BookManagerTest {

    @Autowired
    private BookManager bookManager;

    @Test
    public void selectBook(){

        List<Book> books = bookManager.findAll();
        assertThat(books, is(not(nullValue())));
    }


}
