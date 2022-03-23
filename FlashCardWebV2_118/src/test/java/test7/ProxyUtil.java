package test7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import idv.tool.Debug;

public class ProxyUtil {

	CarI car;

	public ProxyUtil(CarI car) {
		this.car = car;
	}

	public  Object getProxy() {

		return Proxy.newProxyInstance(this.getClass().getClassLoader(),
				car.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {

						Object result = null;

						Debug.test("before", method.getName());

						result = method.invoke(car, args);

						Debug.test("after", method.getName());
						return result;
					}
				});
	}
}
