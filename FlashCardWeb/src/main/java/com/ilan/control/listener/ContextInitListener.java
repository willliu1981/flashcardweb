package com.ilan.control.listener;

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

import com.ilan.appinitialization.Config;
import com.ilan.appinitialization.factory.FactoryConfig;
import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.control.factory.daofactory.user.IUserdataDao;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;

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
		Config.init(sce.getServletContext().getInitParameter("config"));

		FactoryConfig fconfig = new ClassPathXmlApplicationContext("config/config.xml")
				.getBean(FactoryConfig.class);

		Config.setFactoryConfig(fconfig);

	}

}
