package test2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.jupiter.api.Test;

import idv.debug.Debug;

public class Test1 {
	@Test
	public void test1() {
		Book  b = new Book ();
		Type genericSuperclass = b.getClass().getGenericSuperclass();

		//ParameterizedType parameterizedType = ((ParameterizedType) genericSuperclass);
		
		Type[] parameterizedType = ((ParameterizedType) genericSuperclass).getActualTypeArguments();

		/*Type[] actualTypeArguments = ((ParameterizedType) b.getClass()
				.getGenericSuperclass()).getActualTypeArguments();
		*/
		Debug.test(parameterizedType);
	}
}
