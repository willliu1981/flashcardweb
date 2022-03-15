package idv.fc.interceptorhandler;

import javax.servlet.http.HttpSession;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class UserHandler extends InterceptHandler {

	@Override
	public boolean preHandle(MethodProxy methodProxy, HttpSession session) {

		// Debug.test(this, "pre..." + methodProxy.getSignature().getName());

		String auth = (String) session.getAttribute("auth");
		if (auth != null) {
			if (auth.equals("admin")) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void postHandle(MethodProxy methodProxy, HttpSession session) {
		// Debug.test(this, "post...");
	}

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filterMethod("authority").filterMethod("tag");
	}

}
