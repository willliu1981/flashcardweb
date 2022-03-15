package idv.fc.proxy.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.util.ClassUtils;

import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class InterceptorImpl extends BaseInterceptor {
	private InterceptHandlerWrap interceptHandlerWrap = new InterceptHandlerWrap(
			DEFAULTINTERCEPTHANDLER);

	private static final InterceptHandler DEFAULTINTERCEPTHANDLER = new InterceptHandler() {

		@Override
		protected void init(MethodFilter methodFilter) {
			methodFilter.filterMethod(FINALIZE);
		}

		@Override
		protected boolean preHandle(ParamWrap paramWrap) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void postHandle(ParamWrap paramWrap) {
			// TODO Auto-generated method stub

		}
	};

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
			MethodProxy methodProxy, HttpSession session) throws Throwable {
		Object returnValue = null;
		ParamWrap paramWrap = new ParamWrap(proxy, method, args, methodProxy, session);

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
