package hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		try {

			Configuration hibConfiguration = new Configuration().addResource("hibernate.cfg.xml").configure();

			serviceRegistry = new ServiceRegistryBuilder().applySettings(hibConfiguration.getProperties())
					.buildServiceRegistry();

			sessionFactory = hibConfiguration.buildSessionFactory(serviceRegistry);
			
			System.err.println("Initial SessionFactory creation OK.");

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}
}