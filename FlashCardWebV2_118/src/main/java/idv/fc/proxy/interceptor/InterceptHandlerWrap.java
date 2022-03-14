package idv.fc.proxy.interceptor;

import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;

public class InterceptHandlerWrap {

	private int handlerIndex;
	private List<InterceptHandler> interceptHandlers = new ArrayList<>();

	public InterceptHandlerWrap(InterceptHandler defaultInterceptHandler) {
		this.interceptHandlers.add(defaultInterceptHandler);
	}

	public void addInterceptHandler(InterceptHandler interceptHandler) {
		this.interceptHandlers.add(interceptHandler);
	}

	public boolean doPreHandler(MethodProxy methodProxy) {
		handlerIndex = 0;
		for (InterceptHandler interceptHandler : interceptHandlers) {
			if (!interceptHandler.doPreHandle(methodProxy)) {
				return false;
			}
		}
		handlerIndex++;

		return true;
	}

	public void doPostHandler(MethodProxy methodProxy) {
		int handlerIndex = this.handlerIndex;
		while (handlerIndex >= 0) {
			interceptHandlers.get(handlerIndex).postHandle();
			handlerIndex--;
		}

	}

}
