package tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import idv.fc.controller.FlashcardController;

@Component
public class SpringUtil implements ApplicationContextAware {
	private static Logger logger = LoggerFactory
			.getLogger(FlashcardController.class);
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}

	}

	public static ApplicationContext getApplicationContext() {
		return SpringUtil.applicationContext;
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		logger.info("ac:" + getApplicationContext());
		return getApplicationContext().getBean(name, clazz);
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static <T> T getBean(Class<T> clazz, Object... args) {
		return getApplicationContext().getBean(clazz, args);
	}
}
