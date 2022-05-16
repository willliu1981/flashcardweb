package idv.kw.tag.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import idv.kw.tag.itf.TagFacade;

public class TagFactory {
	public static <T extends TagFacade, E> T getFacade(List<E> datas,
			Class<T> facadeType) {
		T newInstance = null;
		try {
			Constructor<T> constructor = facadeType
					.getDeclaredConstructor(List.class);
			newInstance = constructor.newInstance(datas);

		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return newInstance;
	}

	public static <T extends TagFacade, E> T getFacade(E data,
			Class<T> facadeType) {
		T newInstance = null;
		try {
			Constructor<T> constructor = facadeType
					.getDeclaredConstructor(List.class);
			newInstance = constructor.newInstance(data);

		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return newInstance;
	}
}
