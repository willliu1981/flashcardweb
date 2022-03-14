package idv.fc.proxy.interceptor;

import java.util.ArrayList;
import java.util.List;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public abstract class InterceptHandler {
	public static String FINALIZE = "finalize";// GC 回收
	private MethodFilter methodFilter = new MethodFilter();

	public static class MethodFilter {
		private List<String> methodNames = new ArrayList<>();

		public MethodFilter filterMethod(String name) {
			methodNames.add(name);
			return this;
		}

		public boolean isContain(String name) {
			return methodNames.contains(name);
		}

	}

	public MethodFilter filterMethod(String name) {
		return methodFilter.filterMethod(name);
	}

	protected abstract boolean preHandle(MethodProxy methodProxy);

	public boolean doPreHandle(MethodProxy methodProxy) {
		Debug.test(this, methodProxy.getSignature().getName());
		boolean allow = methodFilter.isContain(methodProxy.getSignature().getName());
		return allow && preHandle(methodProxy);
	}

	public abstract void postHandle();
}
