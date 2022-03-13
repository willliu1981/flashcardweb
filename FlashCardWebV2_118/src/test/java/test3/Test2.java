package test3;

import idv.fc.model.User;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.concretion.UserInterceptor;
import idv.fc.tool.Debug;

public class Test2 {
	public static void main(String[] args) {
		User user = new User();
		User proxy = (User) ProxyFactory
				.getProxyInstance(new UserInterceptor().setTarget(user));

		proxy.setAge(2);

		Debug.test(null, "main#user..." + user.getClass());
		Debug.test(null, "main#proxy..." + proxy.getClass());
	}
}
