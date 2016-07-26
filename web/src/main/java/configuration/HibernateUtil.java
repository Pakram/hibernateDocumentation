package configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pojo.Event;
import pojo.Person;

import java.util.Properties;

/**
 * Created by Pakram on 24.07.2016.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration hibernateConfiguration = new Configuration();
            Properties hibernateProperties = new Properties();

            hibernateProperties.put("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
            hibernateProperties.put("hibernate.connection.url", "jdbc:hsqldb:mem:test");
           // hibernateProperties.put("hibernate.connection.url", "jdbc:hsqldb:file:test");
            hibernateProperties.put("hibernate.connection.username", "sa");
            hibernateProperties.put("hibernate.connection.pool_size", 5);
            hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
            hibernateProperties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            hibernateProperties.put("hibernate.current_session_context_class", "thread");
            hibernateProperties.put("hibernate.show_sql", true);
            hibernateProperties.put("debug", true);
            hibernateProperties.put("hibernate.format_sql", true);
            hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
            hibernateConfiguration.setProperties(hibernateProperties);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(hibernateConfiguration.getProperties()).build();
            sessionFactory = hibernateConfiguration.addAnnotatedClass(Person.class).addAnnotatedClass(Event.class)
                    .buildSessionFactory(serviceRegistry);


        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
