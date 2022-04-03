package gameobject.tool;

import java.util.ArrayList;
import java.util.List;

import gameobject.adapter.AdapterI;

public class AdapterListConverter {

	@SuppressWarnings("unchecked")
	public static <T,E extends AdapterI<T>> List<E> convert(List<T> list,Class<E> clazz) {

		List<E> adptList =new ArrayList<>();
		list.stream().forEach(e->{
			try {
				AdapterI<T> adpt = clazz.newInstance();
				adpt.setTarget(e);
				adptList.add((E) adpt);
			} catch (InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
		});
		
		return adptList;
	}
}
