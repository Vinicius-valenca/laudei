package hibernate.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		try {

			Map<String,String> jdbcUrlSettings = new HashMap<>();
			String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
			if (null != jdbcDbUrl) {
			  jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
			}


			Configuration hibConfiguration = new Configuration().addResource("hibernate.cfg.xml").configure();

			serviceRegistry = new StandardServiceRegistryBuilder().
				    configure("hibernate.cfg.xml").
				    applySettings(jdbcUrlSettings).
				    build();

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