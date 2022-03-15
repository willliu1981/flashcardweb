package idv.fc.proxy.interceptor;

import java.util.ArrayList;
import java.util.List;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

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

	protected abstract boolean preHandle(MethodProxy methodProxy);

	public boolean doPreHandle(MethodProxy methodProxy) {
		boolean contain = methodFilter.isContain(methodProxy.getSignature().getName());
		Debug.test(this, methodProxy.getSignature().getName());
		Debug.test(this, contain);

		if (contain) {
			return preHandle(methodProxy);
		}

		return true;

	}

	public abstract void postHandle();
}
