package test3;

import idv.fc.model.User;
import idv.fc.proxy.InterceptorAdapter;
import idv.fc.proxy.ProxyFactory;
import idv.fc.tool.Debug;

public class Test1 {

	public static void main(String[] args) {
		User user = new User();

		ProxyFactory factory = new ProxyFactory();
		User userProxy = (User) ProxyFactory
				.getProxyInstance(new InterceptorAdapter<User>() {

				}.setTarget(user));

		userProxy.setAuthority("x");

		Debug.test(Test1.class, userProxy.getAuthority());

	}

}
