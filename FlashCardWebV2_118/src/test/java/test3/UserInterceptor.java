package test3;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;
import test3.Test1.Car;

public class UserInterceptor extends AbsInterceptor {

	private Object target;

	@Override
	public void setTarget(Object target) {
		this.target = target;

	}

	@Override
	public Object getTarget() {
		return this.target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
			throws Throwable {
		Car car = (Car) obj;

		System.out.println("start..." + proxy.getSignature().getName());
		System.out.println("invoke...");

		Object value = null;
		boolean excuteInvoke = true;
		if (method.getName().equals("run")) {
			if (car.getDriverUser().getAge() < 18) {
				System.out.println(car.getDriverUser().getDisplay_name()
						+ " can't run the " + car.getName());
				excuteInvoke = false;
			}
		}

		if (excuteInvoke) {
			value = method.invoke(target, args);
		}

		System.out.println("sumbit..." + value);
		System.out.println("");

		return value;
	}

}
