package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public abstract class BaseInterceptor<T> implements MethodInterceptor {

	private T target;

	public BaseInterceptor() {

	}

	public BaseInterceptor(T target) {
		this.target = target;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(T target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {

		return this.intercept((T) obj, method, args, proxy, false);
	}

	public Object intercept(T proxy, Method method, Object[] args,
			MethodProxy methodProxy, boolean any) throws Throwable {

		return method.invoke(getTarget(), args);

	}

}
