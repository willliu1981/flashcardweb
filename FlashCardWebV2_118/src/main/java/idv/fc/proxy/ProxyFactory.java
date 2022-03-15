package idv.fc.proxy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import idv.fc.exception.FindErrorException;
import idv.fc.proxy.interceptor.BaseInterceptor;
import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptorImpl;
import idv.fc.tool.SpringUtil;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory<T> {
	public static final String USERPROXYFACTORY = "UserProxyFactory";
	private ProxyBuilder<T> proxyBuilder = new ProxyBuilder<>();
	private List<InterceptHandler> interceptHandlers = new ArrayList<>();

	public static class ProxyBuilder<T2> {
		private T2 target;
		private BaseInterceptor interceptor;
		private List<InterceptHandler> interceptHandlers = new ArrayList<>();
		private HttpSession session;

		public T2 getTarget() {
			return target;
		}

		public ProxyBuilder<T2> setTarget(T2 target) {
			this.target = target;
			return this;
		}

		public HttpSession getSession() {
			return session;
		}

		public ProxyBuilder<T2> setSession(HttpSession session) {
			this.session = session;
			return this;
		}

		public BaseInterceptor getInterceptor() {
			return interceptor;
		}

		public ProxyBuilder<T2> setInterceptor(BaseInterceptor interceptor) {
			this.interceptor = interceptor;
			return this;
		}

		public ProxyBuilder<T2> addInterceptHandler(InterceptHandler interceptHandler) {
			this.interceptHandlers.add(interceptHandler);
			return this;
		}

		private List<InterceptHandler> getInterceptHandlers() {
			return this.interceptHandlers;
		}

		public T2 getProxyInstance() {

			if (this.getInterceptor() == null
					|| this.getInterceptor().isHandlerEmptyExceptDefault()) {
				this.setInterceptor(new InterceptorImpl(this.getInterceptHandlers()));
			}

			// 以 factory 的 target 為主,覆寫 interceptor 的 target
			if (this.getTarget() != null) {
				this.getInterceptor().setTarget(this.getTarget());
				this.getInterceptor().setSession(session);
			} else {
				if (this.getInterceptor().getTarget() == null) {
					throw new FindErrorException(
							this.getClass() + ":can't find target");
				}
			}

			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(this.getInterceptor().getTarget().getClass());
			enhancer.setCallback(this.getInterceptor());

			return (T2) enhancer.create();
		}

	}

	protected ProxyBuilder<T> getProxyBuilder() {
		return proxyBuilder;
	}

	public static <T> ProxyBuilder<T> setTarget(T target) {
		return new ProxyFactory<T>().getProxyBuilder().setTarget(target);
	}

	public static <T> ProxyBuilder<T> setInterceptor(BaseInterceptor interceptor) {
		return new ProxyFactory<T>().getProxyBuilder().setInterceptor(interceptor);
	}

	public static <T> ProxyBuilder<T> addInterceptHandler(
			InterceptHandler interceptHandler) {
		return new ProxyFactory<T>().getProxyBuilder()
				.addInterceptHandler(interceptHandler);
	}

//	public static <T> ProxyBuilder<T> setInterceptHandler(
//			List<InterceptHandler> handlers) {
//		ProxyBuilder<T> builder = new ProxyFactory<T>().getProxyBuilder();
//		handlers.forEach(x -> builder.addInterceptHandler(x));
//
//		return builder;
//	}

	public static <T> ProxyBuilder<T> setInterceptHandler(ProxyBuilder<T> builder,
			List<InterceptHandler> handlers) {
		handlers.forEach(x -> builder.addInterceptHandler(x));

		return builder;
	}

	public void setHandlers(List<InterceptHandler> handlers) {
		this.interceptHandlers = handlers;
	}

	public static <T> T getProxyInstance(String proxyFactoryName, T target) {
		return getProxyInstance(proxyFactoryName, target, null);
	}

	public static <T> T getProxyInstance(String proxyFactoryName, T target,
			HttpSession session) {

		ProxyFactory<T> factory = SpringUtil.getBean(proxyFactoryName,
				ProxyFactory.class);

		return setInterceptHandler(factory.proxyBuilder, factory.interceptHandlers)
				.setTarget(target).setSession(session).getProxyInstance();
	}

}
