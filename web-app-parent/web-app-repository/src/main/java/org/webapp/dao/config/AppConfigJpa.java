package org.webapp.dao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.webapp.dao.jpa.BookManager;

@Configuration
@Profile({"jpa"})
public class AppConfigJpa {


}
