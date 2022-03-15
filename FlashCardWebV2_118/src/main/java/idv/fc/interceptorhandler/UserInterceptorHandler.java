package idv.fc.interceptorhandler;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;

public class UserInterceptorHandler extends InterceptHandler {

	@Override
	public boolean preHandle(ParamWrap paramWrap) {

		// Debug.test(this, "pre..." + methodProxy.getSignature().getName());

		String auth = (String) paramWrap.getSession().getAttribute("auth");
		if (auth != null) {
			if (auth.equals("admin")) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void postHandle(ParamWrap paramWrap) {
		// Debug.test(this, "post...");
	}

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filterMethod("authority").filterMethod("tag");
	}

}
