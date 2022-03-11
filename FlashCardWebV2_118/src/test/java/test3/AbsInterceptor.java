package test3;

import net.sf.cglib.proxy.MethodInterceptor;

public abstract class AbsInterceptor implements MethodInterceptor {

	public abstract void setTarget(Object target);

	public abstract Object getTarget();

}
