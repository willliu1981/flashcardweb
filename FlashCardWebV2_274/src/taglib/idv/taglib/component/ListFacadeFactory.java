package idv.taglib.component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ListFacadeFactory {

	public static <T extends ListFacade, E> T getListFacade(List<E> datas,
			Class<T> listFacadeType) {
		T newInstance = null;
		try {
			Constructor<T> constructor = listFacadeType
					.getDeclaredConstructor(List.class);
			newInstance = constructor.newInstance(datas);

		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return newInstance;
	}

}
