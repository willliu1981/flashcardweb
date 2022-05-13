package tool.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import idv.debug.Debug;
import spring.XmlUrlFactory;

@Component
public class MySpringUtil extends SpringUtil {
	public static String TEST = "test";
	public static String DEFAULT = "default";
	private static String defaultBaseConfigXmlUrl = "classpath:spring/test.xml";
	private static MySpringUtil singleton;

	//應限加載一次
	public static void loadXml(String type) {

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				defaultBaseConfigXmlUrl);
		XmlUrlFactory xmlUrlsFactory = classPathXmlApplicationContext
				.getBean("xmlUrlFactory", XmlUrlFactory.class);

		ApplicationContext applicationContext = null;

		if (type == null) {
			type = "test";
		}

		applicationContext = new ClassPathXmlApplicationContext(
				xmlUrlsFactory.getUrls(type));

		if (getApplicationContext() == null) {
			singleton = new MySpringUtil();
			singleton.setApplicationContext(applicationContext);
		}

	}

}
