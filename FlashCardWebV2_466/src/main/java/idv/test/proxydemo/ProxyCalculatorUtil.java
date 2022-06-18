package idv.test.proxydemo;

import java.lang.reflect.Proxy;

public class ProxyCalculatorUtil<T> {

	public ProxyCalculatorUtil(T claculator) {
		super();
		this.claculator = claculator;
	}

	private T claculator;

	public Object getProxy() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?>[] interfaces = this.claculator.getClass().getInterfaces();
		Object newProxyInstance =   Proxy.newProxyInstance(classLoader, interfaces,
				new CalculatorHandler<T>(claculator));

		return newProxyInstance;
	}
}
