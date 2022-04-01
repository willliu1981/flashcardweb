package idv.tool.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MySpringUtil {

	private static ApplicationContext applicationContext;

	public static MySpringUtil setApplicationContext(String applicationContext)
			throws BeansException {
		if (MySpringUtil.applicationContext == null) {
			MySpringUtil.applicationContext = new ClassPathXmlApplicationContext(
					applicationContext);

		}
		return new MySpringUtil();
	}

	public static ApplicationContext getApplicationContext() {

		return MySpringUtil.applicationContext;
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static <T> T getBean(Class<T> clazz, Object... args) {
		return getApplicationContext().getBean(clazz, args);
	}
}
