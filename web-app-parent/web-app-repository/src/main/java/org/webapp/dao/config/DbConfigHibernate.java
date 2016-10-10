package org.webapp.dao.config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@Profile("hibernate")
//@Transactional(value = "transactionManager")
@EnableTransactionManagement
@ComponentScan({"org.webapp.dao"})
public class DbConfigHibernate {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Properties hibernateProperties;

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() throws IOException {

        LocalSessionFactoryBean localSessionFactoryBean = generateSessionFactoryBean(new String[]{"org.webapp.model"},
                dataSource, hibernateProperties);
        SessionFactory sessionFactory = localSessionFactoryBean.getObject();
        return sessionFactory;
    }

//    @Bean(name = "sessionFactory")
//    public SessionFactory sessionFactory() {
//
//        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
//        return builder
//                .addProperties(getHibernateProperties())
//                .buildSessionFactory();
//    }

    private static LocalSessionFactoryBean generateSessionFactoryBean(String[] basePackage, DataSource dataSource, Properties hibernateProperties)
            throws IOException {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(basePackage);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        localSessionFactoryBean.afterPropertiesSet();
        return localSessionFactoryBean;
    }
}