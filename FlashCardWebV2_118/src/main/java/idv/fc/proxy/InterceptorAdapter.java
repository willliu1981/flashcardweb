package idv.fc.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

public class InterceptorAdapter<T> extends AbsInterceptor<T> {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {

		return null;
	}

}
