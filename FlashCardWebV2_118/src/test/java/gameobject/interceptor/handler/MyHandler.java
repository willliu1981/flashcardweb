package gameobject.interceptor.handler;

import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.tool.Debug;

public class MyHandler extends InterceptHandler {

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filter("absolutePosition");
	}

	@Override
	protected boolean preHandle(ParamWrap paramWrap) {
		
		return true;
	}

	@Override
	public void postHandle(ParamWrap paramWrap) {
		// TODO Auto-generated method stub

	}

}
