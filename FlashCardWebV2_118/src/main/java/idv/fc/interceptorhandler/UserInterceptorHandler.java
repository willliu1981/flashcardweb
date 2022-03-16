package idv.fc.interceptorhandler;

import javax.servlet.http.HttpSession;

import idv.fc.exception.FindErrorException;
import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.fc.tool.Debug;

public class UserInterceptorHandler extends InterceptHandler {

	@Override
	public boolean preHandle(ParamWrap paramWrap) {

		// *
		String auth = null;
		try {
			auth = (String) paramWrap.getShuttle().getValue("token");

		} catch (FindErrorException e) {
			Debug.test(this.getClass(), e);
		}

		if (auth != null) {
			if (auth.equals("tk123456")) {
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
