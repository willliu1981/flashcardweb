package idv.taglib.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import idv.taglib.factory.lister.ListFacade;

public class FacadeFactory {

	public static <T extends ListFacade, E> T getListFacade(List<E> datas,
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

	/*public static <T extends EditorFacade, E> T getEditFacade(List<E> datas,
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
	}*/

}
