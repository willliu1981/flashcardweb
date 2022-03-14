package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;

import org.springframework.web.servlet.ModelAndView;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class InterceptorImpl<T> extends BaseInterceptor<T> {

	private InterceptHandler interceptHandler;
	private static final InterceptHandler DEFAULTINTERCEPTHANDLER = new InterceptHandler() {

		@Override
		protected boolean preHandle(MethodProxy methodProxy) {
			return true;
		}

		@Override
		public void postHandle() {
		}
	};

	{
		DEFAULTINTERCEPTHANDLER.filterMethod(InterceptHandler.FINALIZE);
	}

	private InterceptHandlerWrap interceptHandlerWrap = new InterceptHandlerWrap(
			DEFAULTINTERCEPTHANDLER);

	public InterceptorImpl() {

	}

	public InterceptorImpl(InterceptHandler handler) {
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

		boolean allow = interceptHandlerWrap.doPreHandler(methodProxy);

		if (allow) {
			returnValue = method.invoke(getTarget(), args);
		}

		interceptHandlerWrap.doPostHandler(methodProxy);

		return returnValue;
	}

}
