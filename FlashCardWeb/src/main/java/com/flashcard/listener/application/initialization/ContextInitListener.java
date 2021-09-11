package com.flashcard.listener.application.initialization;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flashcard.application.config.AppConfig;
import com.flashcard.application.config.FactoryConfig;
import com.flashcard.factory.dao.user.IUserDao;
import com.flashcard.factory.dao.user.IUserdataDao;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;

/**
 * Application Lifecycle Listener implementation class ContextInitListener
 *
 */

public class ContextInitListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ContextInitListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */

	public void contextInitialized(ServletContextEvent sce) {
		AppConfig.init(sce.getServletContext().getInitParameter("contextConfigLocation"));

	}

}
