package idv.fc.proxy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import idv.fc.exception.FindErrorException;
import idv.fc.proxy.interceptor.BaseInterceptor;
import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptorImpl;
import idv.fc.proxy.interceptor.Shuttle;
import idv.fc.tool.SpringUtil;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory<T> {
	public static final String USERPROXYFACTORY = "UserProxyFactory";
	private List<InterceptHandler> interceptHandlers = new ArrayList<>();
	// 應用於spring xml 自動注入

	public static class ProxyBuilder<E> {
		private E target;
		private BaseInterceptor interceptor;
		private List<InterceptHandler> interceptHandlers = new ArrayList<>();
		private Shuttle shuttle;

		public E getTarget() {
			return target;
		}

		public ProxyBuilder<E> setTarget(E target) {
			this.target = target;
			return this;
		}

		public Shuttle getShuttle() {
			return this.shuttle;
		}

		public ProxyBuilder<E> setShuttle(Shuttle shuttle) {
			this.shuttle = shuttle;
			return this;
		}

		public BaseInterceptor getInterceptor() {
			return interceptor;
		}

		public ProxyBuilder<E> setInterceptor(BaseInterceptor interceptor) {
			this.interceptor = interceptor;
			return this;
		}

		public ProxyBuilder<E> addInterceptHandler(InterceptHandler interceptHandler) {
			this.interceptHandlers.add(interceptHandler);
			return this;
		}

		private List<InterceptHandler> getInterceptHandlers() {
			return this.interceptHandlers;
		}

		public E getProxyInstance() throws FindErrorException {

			if (this.getInterceptor() == null
					|| this.getInterceptor().isHandlerEmptyExceptDefault()) {
				this.setInterceptor(new InterceptorImpl(this.getInterceptHandlers()));
			}

			// 以 factory 的 target 為主,覆寫 interceptor 的 target
			if (this.getTarget() != null) {
				this.getInterceptor().setTarget(this.getTarget());
				this.getInterceptor().setShuttle(shuttle);
			} else {
				if (this.getInterceptor().getTarget() == null) {
					throw new FindErrorException(
							this.getClass() + ":can't find target");
				}
			}

			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(this.getInterceptor().getTarget().getClass());
			enhancer.setCallback(this.getInterceptor());

			return (E) enhancer.create();
		}

	}

	protected ProxyBuilder<T> getProxyBuilder() {
		return new ProxyBuilder<T>();
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

	public void setHandlers(List<InterceptHandler> handlers) {
		this.interceptHandlers = handlers;
	}

	public List<InterceptHandler> getHandlers() {
		return this.interceptHandlers;
	}

	public static <T> T getProxyInstance(String proxyFactoryName, T target)
			throws FindErrorException {
		return getProxyInstance(proxyFactoryName, target, null);
	}

	public static <T> T getProxyInstance(String proxyFactoryName, T target,
			Shuttle shuttle) throws FindErrorException {
		ProxyFactory<T> factory = SpringUtil.getBean("UserProxyFactory",
				ProxyFactory.class);
		ProxyBuilder<T> builder = new ProxyBuilder<T>();
		factory.getHandlers().forEach(x -> builder.addInterceptHandler(x));

		if (shuttle == null) {
			shuttle = new Shuttle();
		}

		builder.setTarget(target).setShuttle(shuttle);

		return builder.getProxyInstance();
	}

}
