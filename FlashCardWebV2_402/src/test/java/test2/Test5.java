package test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import idv.debug.Debug;
import idv.test.TestLog;

public class Test5 extends TestLog implements Runnable {

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Book b = new Book();

		Object o = b;

		MyProduct facade = getProduct(o, MyProduct.class, o.getClass());

		Debug.test(facade);
	}

	public static <T extends IProduct> T getProduct(Object data,
			Class<T> facadeType, Class<?> dataType)
			throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Constructor<T> declaredConstructor = facadeType
				.getDeclaredConstructor(dataType);
		T newInstance = declaredConstructor.newInstance(data);

		return newInstance;
	}

	long a;

	@Test
	public void test1() throws InterruptedException {

		Thread[] ts = new Thread[10000];

		long start = System.currentTimeMillis();
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread(this);
			ts[i].start();

		}

		for (int i = 0; i < ts.length; i++) {
			ts[i].join();

		}

		logger.info("a=" + a);
		logger.info("time=" + (System.currentTimeMillis() - start));
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 10000) {
			synchronized (this) {
				a++;

			}
			i++;
		}

	}

}
