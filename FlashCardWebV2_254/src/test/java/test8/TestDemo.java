package test8;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import idv.fc.exception.FindErrorException;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandler.MethodFilter;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.tool.Debug;

public class TestDemo {

	@Disabled
	@Test
	public void test0() {
		Debug.test(this, Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void test1() {

	}

	@Test
	public void testx() {

	}

	@Test
	public void test2() {
		Car car = new Car();
		car.add();
		Debug.test(this, "t1", car.number);
	}
}
