package idv.util.spring;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends ArrayList<Object> {
	private List<Object> list;

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public boolean add(Object e) {
		return list.add(e);
	}

	@Override
	public Object get(int index) {
		return list.get(index);
	}

}
