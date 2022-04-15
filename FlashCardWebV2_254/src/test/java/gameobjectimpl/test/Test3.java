package gameobjectimpl.test;

import gameobjectimpl.gui.test.Book;
import gameobjectimpl.interceptor.handler.MyHandler;
import idv.fc.exception.FindErrorException;
import idv.fc.proxy.ProxyFactory;

public class Test3 {

	public static void main(String[] args) {
		Book b = new Book("java", 1200);

		try {
			Book proxyInstance = ProxyFactory.setTarget(b)
					.addInterceptHandler(new MyHandler()).getProxyInstance();
			proxyInstance.getName();
		} catch (FindErrorException e) {
			e.printStackTrace();
		}

	}

}
