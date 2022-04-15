package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public abstract class BaseInterceptor implements MethodInterceptor {

	private Object target;
	private Shuttle shuttle;

	public BaseInterceptor() {

	}

	public BaseInterceptor(Object target) {
		this.target = target;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Shuttle getShuttle() {
		return shuttle;
	}

	public void setShuttle(Shuttle shuttle) {
		this.shuttle = shuttle;
	}

	public abstract boolean isHandlerEmptyExceptDefault();

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {

		return this.intercept(obj, method, args, proxy, this.shuttle);
	}

	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy, Shuttle shuttle) throws Throwable {

		return method.invoke(getTarget(), args);

	}

}
