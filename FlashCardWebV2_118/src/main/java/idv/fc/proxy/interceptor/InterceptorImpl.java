package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class InterceptorImpl<T> extends BaseInterceptor<T> {
	private InterceptHandlerWrap interceptHandlerWrap = new InterceptHandlerWrap(
			DEFAULTINTERCEPTHANDLER);

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

	public InterceptorImpl(InterceptHandler... interceptHandlers) {
		this(Arrays.asList(interceptHandlers));
	}

	public InterceptorImpl(List<InterceptHandler> interceptHandlers) {
		for (InterceptHandler interceptHandler : interceptHandlers) {
			interceptHandlerWrap.addInterceptHandler(interceptHandler);
		}
		Debug.test(this, this.interceptHandlerWrap);
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

	@Override
	public boolean isHandlerEmptyExceptDefault() {
		return this.interceptHandlerWrap.isHandlerEmptyExceptDefault();
	}

}
