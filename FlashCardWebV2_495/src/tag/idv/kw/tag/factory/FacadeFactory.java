package idv.kw.tag.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.kw.tag.itf.TagFacade;

public class FacadeFactory {

	public static <T extends TagFacade> T getFacade(Object data,
			Class<T> facadeType, Class<?> dataType) {
		T newInstance = null;
		try {
			Constructor<T> constructor = facadeType
					.getDeclaredConstructor(dataType);
			newInstance = constructor.newInstance(data);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return newInstance;
	}
}
