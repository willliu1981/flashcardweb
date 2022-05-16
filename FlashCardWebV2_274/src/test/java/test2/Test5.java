package test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import idv.debug.Debug;

public class Test5 {

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Book b = new Book();
		
		Object o=b;

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

}
