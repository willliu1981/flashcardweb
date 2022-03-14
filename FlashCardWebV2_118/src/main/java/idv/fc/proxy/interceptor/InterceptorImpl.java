package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;

import org.springframework.web.servlet.ModelAndView;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class InterceptorImpl<T> extends BaseInterceptor<T> {

	private static final InterceptHandler DEFAULTINTERCEPTHANDLER = new InterceptHandler() {

		@Override
		protected boolean preHandle(MethodProxy methodProxy) {
			Debug.test(this, "defult pre:" + methodProxy.getSignature().getName());
			return true;
		}

		@Override
		public void postHandle() {
			Debug.test(this, "defult post");

		}

		@Override
		protected void init(MethodFilter methodFilter) {
			methodFilter.filterMethod(FINALIZE);
		}
	};

	private InterceptHandlerWrap interceptHandlerWrap = new InterceptHandlerWrap(
			DEFAULTINTERCEPTHANDLER);

	public InterceptorImpl(InterceptHandler... interceptHandlers) {
		for (InterceptHandler interceptHandler : interceptHandlers) {
			interceptHandlerWrap.addInterceptHandler(interceptHandler);
		}
	}

	public InterceptorImpl() {

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
