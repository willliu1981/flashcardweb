package idv.taglib.component.facade;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FacadeFactory {

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

	public static <T extends EditFacade, E> T getEditFacade(List<E> datas,
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