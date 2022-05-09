package idv.fc.taglib.component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import tool.Debug;

public class ListFacadeFactory {

	public static <T extends ListFacade, E> T getListFacade(
			HttpServletRequest request, List<E> datas,
			Class<T> listFacadeType) {
		T newInstance = null;
		try {
			Debug.test("lff", request);
			Constructor<T> constructor = listFacadeType.getDeclaredConstructor(
					HttpServletRequest.class, List.class);
			newInstance = constructor.newInstance(request, datas);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return newInstance;
	}

}