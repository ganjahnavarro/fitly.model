package com.gnjb.fitly.model;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.gnjb.fitly.model.user.SecurityQuestion;
import com.gnjb.fitly.model.user.User;
import com.gnjb.fitly.model.user.User.Status;
import com.gnjb.fitly.model.user.User.Type;
import com.gnjb.fitly.model.user.UserDao;

public class HibernateSessionManager {

	private static final Logger LOGGER = Logger.getLogger(HibernateSessionManager.class.getName());

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration config = new Configuration();

				config.addAnnotatedClass(User.class);
				config.addAnnotatedClass(SecurityQuestion.class);

				config.configure();
				serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

				sessionFactory = config.buildSessionFactory(serviceRegistry);

				initStartupUser();
			}
		} catch (Throwable e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static void shutdown() {
		sessionFactory.close();
	}

	private static void initStartupUser() {
		UserDao userDao = new UserDao();
		SecurityQuestion defaultSecurityQuestion = userDao.findSecurityQuestion("default");

		if (defaultSecurityQuestion == null) {
			defaultSecurityQuestion = new SecurityQuestion();
			defaultSecurityQuestion.setCode("default");
			defaultSecurityQuestion.setQuestion("In what city were you born?");
			userDao.save(defaultSecurityQuestion);
		}

		if (userDao.findUser("admin") == null) {
			User user = new User();
			user.setFirstName("Game");
			user.setLastName("Admin");
			user.setUsername("admin");
			user.setPassword("admin");
			user.setType(Type.ADMIN);
			user.setStatus(Status.ACTIVE);
			user.setSecurityQuestion(defaultSecurityQuestion);
			user.setSecurityQuestionAnswer("Pasig City");

			user.setEntryBy("dev");
			user.setEntryDate(new Date());

			userDao.save(user);
		}
	}

}
