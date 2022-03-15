package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public abstract class BaseInterceptor<T> implements MethodInterceptor {

	private T target;
	private HttpSession session;

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

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public abstract boolean isHandlerEmptyExceptDefault();

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {

		return this.intercept((T) obj, method, args, proxy, this.session);
	}

	public Object intercept(T proxy, Method method, Object[] args,
			MethodProxy methodProxy, HttpSession session) throws Throwable {

		return method.invoke(getTarget(), args);

	}

}
