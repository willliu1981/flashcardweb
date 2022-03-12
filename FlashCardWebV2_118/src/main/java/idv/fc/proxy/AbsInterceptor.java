package idv.fc.proxy;

import idv.fc.exception.FindErrorException;
import net.sf.cglib.proxy.MethodInterceptor;

public abstract class AbsInterceptor<T> implements MethodInterceptor {
	private T target;

	public AbsInterceptor<T> setTarget(T target) {
		this.target = target;
		return this;
	}

	public T getTarget() {
		if (this.target == null) {
			throw new FindErrorException(
					this.getClass() + ": target has not been assigned");
		}
		return this.target;
	}

}
