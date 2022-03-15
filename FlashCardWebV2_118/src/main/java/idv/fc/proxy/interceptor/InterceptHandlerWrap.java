package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.cglib.proxy.MethodProxy;

public class InterceptHandlerWrap {

	private int handlerIndex = -1;
	private List<InterceptHandler> interceptHandlers = new ArrayList<>();

	public static class ParamWrap {
		Object proxy;
		Method method;
		Object[] args;
		MethodProxy methodProxy;
		HttpSession session;

		public ParamWrap(Object proxy, Method method, Object[] args,
				MethodProxy methodProxy, HttpSession session) {
			super();
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
			this.session = session;
		}

		public Object getProxy() {
			return proxy;
		}

		public void setProxy(Object proxy) {
			this.proxy = proxy;
		}

		public Method getMethod() {
			return method;
		}

		public void setMethod(Method method) {
			this.method = method;
		}

		public Object[] getArgs() {
			return args;
		}

		public void setArgs(Object[] args) {
			this.args = args;
		}

		public MethodProxy getMethodProxy() {
			return methodProxy;
		}

		public void setMethodProxy(MethodProxy methodProxy) {
			this.methodProxy = methodProxy;
		}

		public HttpSession getSession() {
			return session;
		}

		public void setSession(HttpSession session) {
			this.session = session;
		}

	}

	/**
	 * 強制設一個default handler
	 * @param defaultInterceptHandler
	 */
	public InterceptHandlerWrap(InterceptHandler defaultInterceptHandler) {
		if (defaultInterceptHandler != null) {
			this.interceptHandlers.add(defaultInterceptHandler);
		}
	}

	public void addInterceptHandler(InterceptHandler interceptHandler) {
		this.interceptHandlers.add(interceptHandler);
	}

	public boolean doPreHandler(ParamWrap paramWrap) {
		int index = 0;
		for (InterceptHandler interceptHandler : interceptHandlers) {
			if (!interceptHandler.doPreHandle(paramWrap)) {
				return false;
			} else {
				handlerIndex = index;
			}
			index++;
		}

		return true;
	}

	public void doPostHandler(ParamWrap paramWrap) {
		int handlerIndex = this.handlerIndex;
		while (handlerIndex >= 0) {
			interceptHandlers.get(handlerIndex).doPostHandle(paramWrap);
			handlerIndex--;
		}

	}

	public boolean isHandlerEmptyExceptDefault() {
		return this.interceptHandlers.size() > 0;
	}

}
