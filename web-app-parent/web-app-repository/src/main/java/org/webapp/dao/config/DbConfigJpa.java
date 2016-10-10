package org.webapp.dao.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("jpa")
public class DbConfigJpa {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Properties hibernateProperties;

    /**
     * Transaction Manager For JPA
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new JpaTransactionManager();
    }

    @Bean
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
