package org.centaurus.app.repository;

import org.centaurus.app.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    private SessionFactory sessionFactory;

    public HibernateConfiguration(){
        configure();
        createSessionFactory();
    }

    private Configuration configure(){
        Configuration configuration = new Configuration();

        configuration
//                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect")
//            .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
//            .setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/centaurus")
//            .setProperty("hibernate.connection.username", "root")
//            .setProperty("hibernate.connection.password", "constitution")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
.setProperty("hibernate.connection.driver_class", "org.h2.Driver")
.setProperty("hibernate.connection.url", "jdbc:h2:./GLOBALS;INIT=CREATE SCHEMA IF NOT EXISTS GLOBALS")
.setProperty("hibernate.default_schema", "GLOBALS")
.setProperty("hibernate.connection.username", "sa")
.setProperty("hibernate.connection.password", "")
            .setProperty("hibernate.hbm2ddl.auto", "update")
            .addAnnotatedClass(User.class);
        return configuration;
    }

    public SessionFactory createSessionFactory(){
        sessionFactory =  configure().buildSessionFactory();
        return sessionFactory;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
