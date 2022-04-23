package test1;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.fc.pojo.Vocabulary;
import spring.XmlUrlFactory;
import test.Car;
import test.ICar;
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
	public void test1() {
		MySpringUtil.loadXml("test");
		Vocabulary bean = MySpringUtil.getBean("vocabulary", Vocabulary.class);

		Debug.test("voc", bean);
	}

	@Test
	public void test2() {
		MySpringUtil.loadXml("test");
		Car bean = MySpringUtil.getBean("car1", Car.class);

		Debug.test("car", bean);
	}

	static class BaseCar {
		String msg() {
			return "x1";
		}
	}

	static class ACar extends BaseCar {
		String msg() {
			return "x1";
		}
	}

	static class SCar extends ACar implements ICar {
		public String msg() {
			return "x1";
		}
	}

	@Test
	public void test3() {
		ICar car = new ICar() {

			@Override
			public String msg() {
				return ICar.super.msg();
			}

		};

		Debug.test("car", car);
	}
	
	@Test
	public void test4() {
	
	}

}
