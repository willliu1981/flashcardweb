package idv.fc.proxy.concretion;

import java.lang.reflect.Method;

import idv.fc.model.User;
import idv.fc.proxy.AbsInterceptor;
import idv.fc.tool.Debug;
import net.sf.cglib.proxy.MethodProxy;

public class UserInterceptor extends AbsInterceptor<User> {

	private User target;

	@Override
	public AbsInterceptor setTarget(User target) {
		this.target = target;
		return this;
	}

	@Override
	public User getTarget() {
		return this.target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {
		User user = (User) obj;

		Object value = null;
		boolean excuteInvoke = true;
		if (method.getName().equals("setAuthority")) {
			Debug.test(this, user);
			if (false) {
				excuteInvoke = false;
			}
		}

		if (excuteInvoke) {
			value = method.invoke(target, args);
		}

		return value;
	}

}
