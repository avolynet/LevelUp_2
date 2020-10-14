package ru.levelup.musicians.library.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtilsMusicians {

    private HibernateUtilsMusicians () {

    }

    private static SessionFactory factory;

    static {
        Configuration configuration = new Configuration();
                configuration.configure("hibernate_m.cfg.xml");
        factory = configuration.buildSessionFactory();
    }

    public static SessionFactory getFactory(){
        return factory;
    }
}
