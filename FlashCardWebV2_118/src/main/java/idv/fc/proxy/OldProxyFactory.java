package idv.fc.proxy;

import net.sf.cglib.proxy.Enhancer;

public class OldProxyFactory {

	private OldProxyFactory instance;
	private Object target;

	private OldProxyFactory getInstance() {
		if (this.instance == null) {
			instance = new OldProxyFactory();
		}

		return this.instance;
	}

	public Object getTarget() {
		return getInstance().target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public static OldProxyFactory createNewFactoryInstance(Object target) {
		OldProxyFactory instance = new OldProxyFactory();
		instance.setTarget(target);
		return instance;
	}

	public static Object getProxyInstance(AbsInterceptor instance) {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(instance.getTarget().getClass());
		enhancer.setCallback(instance);

		return enhancer.create();
	}

}
