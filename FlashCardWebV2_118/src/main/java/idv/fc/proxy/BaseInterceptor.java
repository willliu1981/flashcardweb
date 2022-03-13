package idv.fc.proxy;

import java.lang.reflect.Method;

import idv.fc.exception.FindErrorException;
import idv.fc.model.User;
import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public abstract class BaseInterceptor implements MethodInterceptor {

	private Object target;

	public BaseInterceptor(Object target) {
		this.target = target;
	}

	protected Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {
		User user = (User) obj;

		Object value = null;
		boolean excuteInvoke = true;
		if (method.getName().substring(0, 3).equals("set")) {
			Debug.test(this, "ui..." + obj.getClass());
			value = obj;
			method.invoke(getTarget(), args);
			excuteInvoke = false;
		}

		if (excuteInvoke) {
			value = method.invoke(getTarget(), args);
		}

		return value;
	}

}
