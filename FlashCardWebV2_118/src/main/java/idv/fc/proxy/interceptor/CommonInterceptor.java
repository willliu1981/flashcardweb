package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

public class CommonInterceptor<T> extends BaseInterceptor<T> {

	private InterceptHandler interceptHandler;

	public CommonInterceptor() {

	}

	public CommonInterceptor(InterceptHandler handler) {
		this.interceptHandler = handler;
	}

	public InterceptHandler getInterceptHandler() {
		return interceptHandler;
	}

	public void setInterceptHandler(InterceptHandler interceptHandler) {
		this.interceptHandler = interceptHandler;
	}

	@Override
	public Object intercept(T proxy, Method method, Object[] args,
			MethodProxy methodProxy, boolean any) throws Throwable {
		Object returnValue = null;

		boolean allow = InterceptHandler.getDefaultInterceptHandler()
				.doPreHandle(methodProxy) || interceptHandler.doPreHandle(methodProxy);

		if (allow) {
			returnValue = method.invoke(getTarget(), args);
		}

		interceptHandler.postHandle();

		return returnValue;
	}

}
