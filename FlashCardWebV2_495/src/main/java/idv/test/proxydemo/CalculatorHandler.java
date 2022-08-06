package idv.test.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler<T> implements InvocationHandler {

	public CalculatorHandler(T target) {
		super();
		this.target = target;
	}

	private T target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("method name :"+method.getName());
		System.out.println("before");

		Object result = method.invoke(target, args);
		System.out.println("process result:"+result);

		System.out.println("after");

		return result;
	}

}
