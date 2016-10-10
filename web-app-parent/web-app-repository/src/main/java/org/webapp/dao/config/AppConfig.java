package org.webapp.dao.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.webapp.dao.hibernate.GenericDaoHibernate;

import javax.sql.DataSource;

@Configuration
@Import({AppConfigHibernate.class, AppConfigJpa.class})
public class AppConfig {

    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private SessionFactory sessionFactory;

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }


}
