package idv.tool.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class MySpringUtil {

	private String[] applicationContexts;

	private static ApplicationContext applicationContext;

	public static MySpringUtil setApplicationContext(String applicationContext)
			throws BeansException {
		return setApplicationContext(new String[] { applicationContext });
	}

	public static MySpringUtil setApplicationContext(String[] applicationContexts)
			throws BeansException {
		//		if (MySpringUtil.applicationContext == null) {
		//			MySpringUtil.applicationContext = new ClassPathXmlApplicationContext(
		//					applicationContexts);
		//
		//		}

		MySpringUtil mySpringUtil = new MySpringUtil();
		mySpringUtil.applicationContexts = applicationContexts;
		return mySpringUtil;
	}

	public ApplicationContext getApplicationContext() {

		return new ClassPathXmlApplicationContext(applicationContexts);
	}

	public Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	public <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public <T> T getBean(Class<T> clazz, Object... args) {
		return getApplicationContext().getBean(clazz, args);
	}
}
