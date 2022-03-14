package idv.fc.proxy.interceptor.concretion;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.tool.Debug;

public class UserHandler implements InterceptHandler {

	@Override
	public boolean preHandle() {
		Debug.test(this, "pre...");
		return true;
	}

	@Override
	public void postHandle() {
		Debug.test(this, "post...");
	}

}
