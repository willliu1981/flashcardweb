package idv.fc.interceptorhandler;

import javax.servlet.http.HttpSession;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;

public class UserInterceptorHandler extends InterceptHandler {

	@Override
	public boolean preHandle(ParamWrap paramWrap) {

		// *
		String auth = (String) ((HttpSession) paramWrap.getShuttle().get("session"))
				.getAttribute("token");
		if (auth != null) {
			if (auth.equals("admin")) {
				return true;
			}
		}

		// */

		return false;
	}

	@Override
	public void postHandle(ParamWrap paramWrap) {
	}

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filter("auth").filter("tag");
	}

}
