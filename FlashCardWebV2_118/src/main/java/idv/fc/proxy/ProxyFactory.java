package idv.fc.proxy;

import idv.fc.exception.FindErrorException;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

	private Object target;
	private BaseInterceptor interceptor;

	public Object getTarget() {
		return target;
	}

	public ProxyFactory setTarget(Object target) {
		this.target = target;
		return this;
	}

	public BaseInterceptor getInterceptor() {
		return interceptor;
	}

	public ProxyFactory setInterceptor(BaseInterceptor interceptor) {
		this.interceptor = interceptor;
		return this;
	}

	public static ProxyFactory createWithTarget(Object target) {
		ProxyFactory instance = new ProxyFactory();
		instance.setTarget(target);
		return instance;
	}

	public static ProxyFactory createWithInterceptor(BaseInterceptor interceptor) {
		ProxyFactory instance = new ProxyFactory();
		instance.setInterceptor(interceptor);
		return instance;
	}

	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();

		if (this.getInterceptor() == null) {
			throw new FindErrorException(this.getClass() + ":can't find interceptor");
		}

		// 以 factory 的 target 為主,覆寫 interceptor 的 target
		if (this.getTarget() != null) {
			this.getInterceptor().setTarget(this.getTarget());
		} else {
			if (this.getInterceptor().getTarget() == null) {
				throw new FindErrorException(this.getClass() + ":can't find target");
			}
		}

		enhancer.setSuperclass(this.getInterceptor().getTarget().getClass());
		enhancer.setCallback(this.getInterceptor());

		return enhancer.create();
	}

}
