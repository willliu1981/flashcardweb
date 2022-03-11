package test3;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

	public Object getProxyInstance(AbsInterceptor instance) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(instance.getTarget().getClass());
		enhancer.setCallback(instance);

		return enhancer.create();
	}

}
