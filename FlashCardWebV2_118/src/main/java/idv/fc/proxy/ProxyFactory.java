package idv.fc.proxy;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

	public static Object getProxyInstance(AbsInterceptor<?> instance) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(instance.getTarget().getClass());
		enhancer.setCallback(instance);

		return enhancer.create();
	}

}
