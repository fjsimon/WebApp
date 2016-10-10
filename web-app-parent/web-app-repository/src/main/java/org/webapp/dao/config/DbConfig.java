package org.webapp.dao.config;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import({DbConfigHibernate.class, DbConfigJpa.class})
@EnableConfigurationProperties(value = DataSourceProperties.class)
@PropertySource("file:application.properties")
public class DbConfig {

    private static final Logger log = Logger.getLogger(DbConfig.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource getDatasourceConfiguration() {

        log.debug("Configuring DataSource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;
    }

    @Bean(name = "hibernateProperties")
    public Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("hibernate.format_sql", true);
        hibernateProperties.put("hibernate.generate_statistics", false);
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.put("hibernate.use_sql_comments", false);
        hibernateProperties.put("hibernate.connection.pool_size", 1);
        return hibernateProperties;
    }

//    @Bean(name = "liquibase")
//    public SpringLiquibase liquibase(DataSource dataSource) {
//        log.debug("Configuring Liquibase");
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog("classpath:/src/main/resources/liquibase/master.xml");
//        liquibase.setContexts("development, production");
//        return liquibase;
//    }
}
