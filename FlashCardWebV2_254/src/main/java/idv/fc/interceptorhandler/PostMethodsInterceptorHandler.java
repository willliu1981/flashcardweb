package idv.fc.interceptorhandler;

import java.util.HashMap;
import java.util.Map;

import idv.fc.exception.FindErrorException;
import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.tool.Debug;

public class PostMethodsInterceptorHandler extends InterceptHandler {

	@Override
	public boolean preHandle(ParamWrap paramWrap) {

		return false;
	}

	@Override
	public void postHandle(ParamWrap paramWrap) {

		if (paramWrap.getMethodProxy().getSignature().getName().startsWith("set")) {
			Map<String, Object> methods = null;
			try {
				methods = (Map<String, Object>) paramWrap.getShuttle()
						.getValue("methods");
			} catch (FindErrorException e1) {
				methods = new HashMap<>();
			}

			methods.put(paramWrap.getMethodProxy().getSignature().getName(),
					paramWrap.getArgs()[0]);
			try {
				paramWrap.getShuttle().put("methods", methods);
			} catch (FindErrorException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void init(MethodFilter methodFilter) {

	}

}
