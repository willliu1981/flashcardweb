package gameobjectimpl.interceptor.handler;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.tool.Debug;

public class MyHandler extends InterceptHandler {

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filter(FilterParamter.ANY);
	}

	@Override
	protected boolean preHandle(ParamWrap paramWrap) {
		Debug.test(this, "xxx1");
		return true;
	}

	@Override
	public void postHandle(ParamWrap paramWrap) {
		Debug.test(this, "xxx2");
	}

}
