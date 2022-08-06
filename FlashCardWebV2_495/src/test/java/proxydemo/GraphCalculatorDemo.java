package proxydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.debug.Debug;
import idv.test.TestLog;
import idv.test.proxydemo.CircleCalculator;
import idv.test.proxydemo.GraphCalculatorI;
import idv.test.proxydemo.ProxyCalculatorUtil;
import tool.spring.MySpringUtil;
import tool.spring.SpringUtil;

public class GraphCalculatorDemo extends TestLog {

	public static void main(String[] args) {
		CircleCalculator circleCalc = new CircleCalculator();
		int param = 20;
		double clacArea = circleCalc.calcArea(param);
		int clacPerimeter = circleCalc.clacPerimeter(param);
		/*		logger.info("area: " + clacArea);
				logger.info("perimeter: " + clacPerimeter);*/

		ProxyCalculatorUtil<CircleCalculator> util = new ProxyCalculatorUtil<>(
				circleCalc);
		Object proxy = util.getProxy();

		Debug.test(null, proxy);

		/*double proxyClacArea = proxy.clacArea(param);
		int proxyClacPerimeter = proxy.clacPerimeter(param);*/
		/*		logger.info("proxy area: " + proxyClacArea);
				logger.info("proxy perimeter: " + proxyClacPerimeter);*/
	}

	@Test
	public void test1() {
		CircleCalculator circleCalc = new CircleCalculator();
		int param = 20;
		double clacArea = circleCalc.calcArea(param);
		int clacPerimeter = circleCalc.clacPerimeter(param);
		logger.info("area: " + clacArea);
		logger.info("perimeter: " + clacPerimeter);

		ProxyCalculatorUtil<CircleCalculator> util = new ProxyCalculatorUtil<>(
				circleCalc);

		Object proxy2 = util.getProxy();
		logger.info("debug:" + proxy2);

		GraphCalculatorI proxy = (GraphCalculatorI) util.getProxy();
		double proxyClacArea = proxy.calcArea(param);
		int proxyClacPerimeter = proxy.clacPerimeter(param);
		logger.info("proxy area: " + proxyClacArea);
		logger.info("proxy perimeter: " + proxyClacPerimeter);

	}

	@Test
	public void test2() {
		try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/test.xml")) {
			GraphCalculatorI bean = classPathXmlApplicationContext
					.getBean("circleCalculator", GraphCalculatorI.class);
			double calcArea = bean.calcArea(20);
			System.out.println("area=" + calcArea);
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

}
