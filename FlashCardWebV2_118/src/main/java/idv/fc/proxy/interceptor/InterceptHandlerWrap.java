package idv.fc.proxy.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.cglib.proxy.MethodProxy;

public class InterceptHandlerWrap {

	private int handlerIndex = -1;
	private List<InterceptHandler> interceptHandlers = new ArrayList<>();

	/**
	 * 強制設一個default handler
	 * @param defaultInterceptHandler
	 */
	public InterceptHandlerWrap(InterceptHandler defaultInterceptHandler) {
		this.interceptHandlers.add(defaultInterceptHandler);
	}

	public void addInterceptHandler(InterceptHandler interceptHandler) {
		this.interceptHandlers.add(interceptHandler);
	}

	public boolean doPreHandler(MethodProxy methodProxy, HttpSession session) {
		int index = 0;
		for (InterceptHandler interceptHandler : interceptHandlers) {
			if (!interceptHandler.doPreHandle(methodProxy,session)) {
				return false;
			} else {
				handlerIndex = index;
			}
		}
		index++;

		return true;
	}

	public void doPostHandler(MethodProxy methodProxy, HttpSession session) {
		int handlerIndex = this.handlerIndex;
		while (handlerIndex >= 0) {
			interceptHandlers.get(handlerIndex).doPostHandle(methodProxy,session);
			handlerIndex--;
		}

	}

	public boolean isHandlerEmptyExceptDefault() {
		return this.interceptHandlers.size() > 0;
	}

}
