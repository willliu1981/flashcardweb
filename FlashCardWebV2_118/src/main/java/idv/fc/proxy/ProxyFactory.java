package idv.fc.proxy;

import idv.fc.exception.FindErrorException;
import idv.fc.proxy.interceptor.BaseInterceptor;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory<T> {

	private T target;
	private BaseInterceptor<T> interceptor;

	public T getTarget() {
		return target;
	}

	public ProxyFactory<T> setTarget(T target) {
		this.target = target;
		return this;
	}

	public BaseInterceptor<T> getInterceptor() {
		return interceptor;
	}

	public ProxyFactory<T> setInterceptor(BaseInterceptor<T> interceptor) {
		this.interceptor = interceptor;
		return this;
	}

	public static <T> ProxyFactory<T> createWithTarget(T target) {
		ProxyFactory<T> instance = new ProxyFactory();
		instance.setTarget(target);
		return instance;
	}

	public static <T> ProxyFactory<T> createWithInterceptor(
			BaseInterceptor<T> interceptor) {
		ProxyFactory<T> instance = new ProxyFactory<>();
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
