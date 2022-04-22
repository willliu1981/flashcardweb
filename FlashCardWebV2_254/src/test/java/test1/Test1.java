package test1;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.test.Car;
import spring.XmlUrlFactory;
import tool.Debug;
import tool.MySpringUtil;

public class Test1 {
	private final static Logger logger = LoggerFactory.getLogger(Test1.class);

	public static void main(String[] args) {

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/test.xml");
		XmlUrlFactory bean = classPathXmlApplicationContext
				.getBean("XmlUrlFactory", XmlUrlFactory.class);
		Map<String, List<String>> xmlUrls = bean.getXmlUrls();
		xmlUrls.forEach((x, y) -> Debug.test(x, y));
	}

	@Test
	public void test2() {
		MySpringUtil.loadXml("test");
		Car bean = MySpringUtil.getBean("car1", Car.class);

		Debug.test("car", bean);
	}

}
