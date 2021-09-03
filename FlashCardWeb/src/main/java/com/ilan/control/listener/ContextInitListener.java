package com.ilan.control.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ilan.control.config.Config;

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
    public void contextDestroyed(ServletContextEvent sce)  { 

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	Config.init(sce.getServletContext().getInitParameter("config"));
    }
	
}
