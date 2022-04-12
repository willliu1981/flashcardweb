package gameobjectimpl.tool;

import java.util.ArrayList;
import java.util.List;

import gameobjectimpl.adapter.AdapterI;
import gameobjectimpl.component.ComponentAdapter;

public class AdapterLists {

	@SuppressWarnings("unchecked")
	public static <T, E extends AdapterI<T>> List<E> convertToAdapter(List<T> list,
			Class<E> clazz) {

		List<E> adptList = new ArrayList<>();
		list.stream().forEach(e -> {
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

	public static void setComponentPreviosAbsolutePosition(
			List<ComponentAdapter> list) {
		list.forEach(
				comp -> comp.setPreviosAbsolutePosition(comp.getAbsolutePosition()));
	}

}