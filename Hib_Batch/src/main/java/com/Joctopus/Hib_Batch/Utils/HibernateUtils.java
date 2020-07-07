package com.Joctopus.Hib_Batch.Utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Joctopus.Hib_Batch.Entity.Employee1;

public class HibernateUtils {

	// For XML Configuration
	private static SessionFactory xmlSessionFactory = null;

	// For annatation Configuration
	private static SessionFactory annatationSessionFactory = null;

	// For properies Configuration
	private static SessionFactory properiesSessionFactory = null;

	public static SessionFactory getXmlSessionFactory() {

		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration config = new Configuration();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();
			System.out.println("Hibernate serviceRegistry created");

			xmlSessionFactory = config.configure().buildSessionFactory(serviceRegistry);

			return xmlSessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static SessionFactory getAnnatationSessionFactory() {

		try {
			
			Configuration config = new Configuration();
				
			//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			System.out.println("Hibernate serviceRegistry created");

			annatationSessionFactory = config.configure().buildSessionFactory();

			return annatationSessionFactory;
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory buildSessionJavaConfigFactory() {
		try {
			Configuration configuration = new Configuration();

			// Create Properties, can be read from property files too
			Properties props = new Properties();
			props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			props.put("hibernate.connection.url", "jdbc:mysql://localhost/TestDB");
			props.put("hibernate.connection.username", "pankaj");
			props.put("hibernate.connection.password", "pankaj123");
			props.put("hibernate.current_session_context_class", "thread");

			configuration.setProperties(props);

			// we can set mapping file or class with annotation

			configuration.addAnnotatedClass(Employee1.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate Java Config serviceRegistry created");

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {

		annatationSessionFactory = HibernateUtils.getAnnatationSessionFactory();

		return (annatationSessionFactory != null) ? annatationSessionFactory.openSession()
				: annatationSessionFactory.openSession();
	}

}
