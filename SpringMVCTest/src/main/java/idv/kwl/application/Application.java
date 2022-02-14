package idv.kwl.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.kwl.model.UserFactory;

public class Application implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"classpath:idv/kwl/springmvc/springMVC-beanFactory.xml");
		factory.getBean("userFactory");

	}

}
