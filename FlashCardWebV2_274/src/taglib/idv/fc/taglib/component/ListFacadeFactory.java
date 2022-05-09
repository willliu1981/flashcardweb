package idv.fc.taglib.component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ListFacadeFactory {

	public static <T extends ListFacade, E> T getListFacade(
			HttpServletRequest request, List<E> datas,
			Class<T> listFacadeType) {
		T newInstance = null;
		try {
			Constructor<T> constructor = listFacadeType
					.getConstructor(HttpServletRequest.class, List.class);
			newInstance = constructor.newInstance(request, datas);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return newInstance;
	}

}
