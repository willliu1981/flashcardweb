package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import net.sf.cglib.proxy.MethodProxy;

public class InterceptorImpl extends BaseInterceptor {
	private InterceptHandlerWrap interceptHandlerWrap = new InterceptHandlerWrap(null);

	public InterceptorImpl(InterceptHandler... interceptHandlers) {
		this(Arrays.asList(interceptHandlers));
	}

	public InterceptorImpl(List<InterceptHandler> interceptHandlers) {
		for (InterceptHandler interceptHandler : interceptHandlers) {
			interceptHandlerWrap.addInterceptHandler(interceptHandler);
		}
	}

	public InterceptorImpl() {

	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy, Shuttle shuttle) throws Throwable {
		Object returnValue = null;
		ParamWrap paramWrap = new ParamWrap(proxy, method, args, methodProxy,
				this.getShuttle());

		boolean allowance = interceptHandlerWrap.doPreHandler(paramWrap);

		if (allowance) {
			returnValue = method.invoke(getTarget(), args);
		}

		interceptHandlerWrap.doPostHandler(paramWrap);

		return returnValue;
	}

	@Override
	public boolean isHandlerEmptyExceptDefault() {
		return this.interceptHandlerWrap.isHandlerEmptyExceptDefault();
	}

}
