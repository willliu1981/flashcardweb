package test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test3 {

	interface CCC {

	}

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		CCC c = new CCC() {
		};

		Constructor<CCC> declaredConstructor = CCC.class
				.getDeclaredConstructor();

		CCC newInstance = declaredConstructor.newInstance();

		System.out.println(newInstance);

	}

}
