package org.webapp.dao.config;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@Profile("jpa")
@EnableTransactionManagement
@ComponentScan({"org.webapp.dao"})
public class DbConfigJpa {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Properties hibernateProperties;

    /**
     * Transaction Manager For JPA
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws Exception {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() throws IOException {

        LocalSessionFactoryBean localSessionFactoryBean = generateSessionFactoryBean(new String[]{"org.webapp.model"},
                dataSource, hibernateProperties);
        SessionFactory sessionFactory = localSessionFactoryBean.getObject();
        return sessionFactory;
    }

    private static LocalSessionFactoryBean generateSessionFactoryBean(String[] basePackage, DataSource dataSource, Properties hibernateProperties)
            throws IOException {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(basePackage);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        localSessionFactoryBean.afterPropertiesSet();
        return localSessionFactoryBean;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setPackagesToScan("org.webapp.model");
        emfb.setJpaProperties(hibernateProperties);
        emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emfb.setJpaVendorAdapter(adapter);
        emfb.setDataSource(dataSource);
        return emfb;
    }
}
