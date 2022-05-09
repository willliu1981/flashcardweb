package testConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import idv.fc.taglib.component.FlashcardListFacade;
import idv.fc.taglib.component.ListFacade;
import tool.Debug;

public class Test1 {

	@Test
	public void test1() {

	}

	@Test
	public void test2() {
		/*	List<String> datas = new ArrayList<>();
			datas.add("a");
			datas.add("b");
			datas.add("c");*/

		List<Car> datas = new ArrayList<>();
		datas.add(new Car("a1"));
		datas.add(new Car("b1"));
		datas.add(new Car("c1"));

		Name name = new BookName();
		name.setBookName("b1");

		Book create = create(Book.class, datas);
		Debug.test(create);
	}

	public static <T extends Product, E> T create(Class<T> type,
			List<E> datas) {
		T newInstance = null;
		try {
			Constructor<T> constructor = type.getDeclaredConstructor(Name.class,
					int.class, List.class, HttpServletRequest.class);
			newInstance = constructor.newInstance(null, 123, datas, null);
			Debug.test(newInstance);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return newInstance;
	}

	@Test
	public void test3() {
		/*	List<String> datas = new ArrayList<>();
			datas.add("a");
			datas.add("b");
			datas.add("c");*/

		List<Car> datas = new ArrayList<>();
		datas.add(new Car("a1"));
		datas.add(new Car("b1"));
		datas.add(new Car("c1"));

		FlashcardListFacade create = create2(FlashcardListFacade.class, datas);
		Debug.test(create);
	}

	public static <T extends ListFacade, E> T create2(Class<T> type,
			List<E> datas) {
		T newInstance = null;
		try {
			Constructor<T> constructor = type.getDeclaredConstructor(
					HttpServletRequest.class, List.class);
			newInstance = constructor.newInstance(null, datas);
			Debug.test(newInstance);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return newInstance;
	}

}
