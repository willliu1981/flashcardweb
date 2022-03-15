package idv.fc.interceptorhandler;

import java.lang.annotation.Annotation;

import idv.fc.annotation.AnnotationFactory;
import idv.fc.proxy.interceptor.InterceptHandler;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.fc.tool.Debug;
import idv.fc.tool.SpringUtil;

public class UserInterceptorHandler extends InterceptHandler {

	@Override
	public boolean preHandle(ParamWrap paramWrap) {

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
	}

	@Override
	protected void init(MethodFilter methodFilter) {
		methodFilter.filterMethod("authority").filterMethod("tag");
	}

}
