package idv.fc.proxy.interceptor.concretion;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class UserHandler extends InterceptHandler {

	@Override
	public boolean preHandle(MethodProxy methodProxy) {

		Debug.test(this, "pre..." + methodProxy.getSignature().getName());
		return true;
	}

	@Override
	public void postHandle() {
		Debug.test(this, "post...");
	}

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filterMethod("username");
	}

}
