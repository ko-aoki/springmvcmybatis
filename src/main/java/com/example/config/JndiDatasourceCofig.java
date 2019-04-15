package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiTemplate;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Profile("!unit")
@Configuration
public class JndiDatasourceCofig {

    @Bean
    public DataSource dataSource() {
        JndiTemplate jndiTemplate = new JndiTemplate();
        try {
            return jndiTemplate.lookup("java:/jdbc/Postgres", DataSource.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
