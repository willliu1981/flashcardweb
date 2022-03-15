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
		ParamWrap wrap = new ParamWrap(proxy, method, args, methodProxy, session);

		if (methodProxy.getSignature().getName().equals("setAuthority")) {
			Class<?> userClazz = (Class<?>) ClassUtils.getUserClass(proxy.getClass());
			Debug.test(this, "class:" + proxy.getClass());
			Debug.test(this, "user class:" + userClazz);
			Debug.test(this, "super class:" + userClazz.getSuperclass());
			Annotation[] annos = userClazz.getClass().getAnnotations();
			// Annotation[] annos = method.getAnnotations();
			Annotation anno = null;
			if (annos.length > 0) {
				anno = annos[0];
			}
			Debug.test(this, "anno: " + anno);

		}

		boolean allowance = interceptHandlerWrap.doPreHandler(wrap);

		if (allowance) {
			returnValue = method.invoke(getTarget(), args);
		}

		interceptHandlerWrap.doPostHandler(wrap);

		return returnValue;
	}

	@Override
	public boolean isHandlerEmptyExceptDefault() {
		return this.interceptHandlerWrap.isHandlerEmptyExceptDefault();
	}

}
