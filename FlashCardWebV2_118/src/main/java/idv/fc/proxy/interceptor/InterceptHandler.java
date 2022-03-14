package idv.fc.proxy.interceptor;

import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public abstract class InterceptHandler {
	private static String FINALIZE = "finalize";// GC 回收
	private String methodName = "setUsername";

	private static InterceptHandler defaultInterceptHandler = new InterceptHandler() {

		@Override
		protected boolean preHandle(MethodProxy methodProxy) {
			Debug.test(this, "default pre..." + methodProxy.getSignature().getName());
			return true;
		}

		@Override
		public void postHandle() {
			Debug.test(this, "default pre...");
		}

	}.setMethodName(FINALIZE);

	public String getMethodName() {
		return methodName;
	}

	public InterceptHandler setMethodName(String methodName) {
		this.methodName = methodName;
		return this;
	}

	public static InterceptHandler getDefaultInterceptHandler() {
		return defaultInterceptHandler;
	}

	protected abstract boolean preHandle(MethodProxy methodProxy);

	public boolean doPreHandle(MethodProxy methodProxy) {

		boolean allow = methodProxy.getSignature().getName().equals(methodName);
		return allow && preHandle(methodProxy);
	}

	public abstract void postHandle();
}
