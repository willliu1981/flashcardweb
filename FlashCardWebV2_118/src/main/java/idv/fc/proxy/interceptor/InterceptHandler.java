package idv.fc.proxy.interceptor;

import java.util.ArrayList;
import java.util.List;

import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;

/**
 * 應用於 InterceptorImpl
 * @author KuanWei
 *
 */
public abstract class InterceptHandler {
	public static String FINALIZE = "finalize";// GC 回收
	private MethodFilter methodFilter = new MethodFilter();

	public static class MethodFilter {
		private List<String> methodNames = new ArrayList<>();

		public MethodFilter filterMethod(String name) {
			methodNames.add(name);
			return this;
		}

		protected boolean isContain(String name) {
			if (methodNames.contains(name)) {
				return true;
			}

			if (name.startsWith("set") || name.startsWith("set")) {
				char head = name.charAt(3);

				if (Character.isUpperCase(head)) {

					return methodNames
							.contains(Character.toLowerCase(head) + name.substring(4));
				}
			}

			return false;
		}

	}

	public InterceptHandler() {
		init(this.methodFilter);
	}

	abstract protected void init(MethodFilter methodFilter);

	protected MethodFilter filterMethod(String name) {
		return methodFilter.filterMethod(name);
	}

	protected abstract boolean preHandle(ParamWrap paramWrap);

	public boolean doPreHandle(ParamWrap paramWrap) {
		boolean contain = methodFilter
				.isContain(paramWrap.getMethodProxy().getSignature().getName());

		if (contain) {
			return preHandle(paramWrap);
		}

		return true;

	}

	public abstract void postHandle(ParamWrap paramWrap);

	public void doPostHandle(ParamWrap paramWrap) {
		postHandle(paramWrap);
	}
}
