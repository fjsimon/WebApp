package org.webapp.dao.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"hibernate"})
public class AppConfigHibernate {

//    @Autowired
//    private SessionFactory sessionFactory;

//    @Bean
//    public RestaurantRepository restaurantRepository(){
//        return new HibernateRestaurantRepository(sessionFactory);
//    }
//
//    @Bean
//    public AccountRepository accountRepository(){
//        return new HibernateAccountRepository(sessionFactory);
//    }
//
//    @Bean
//    public AccountManager accountManager(){
//        return new HibernateAccountManager(sessionFactory);
//    }

}

