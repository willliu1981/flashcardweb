package test.injection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class AttributeSet {
	static public class MenuComparator implements Supplier<Object> {
		Random rnd = new Random(new Date().getTime());

		int type;
		List<Object> objs;

		public List<Object> getObjs() {
			return objs;
		}

		@Override
		public Object get() {
			return objs.get(rnd.nextInt(objs.size()));
		}

	}

	MenuComparator comparator = new MenuComparator();
	String name;

	public MenuComparator getComparator() {
		return this.comparator;
	}

	public void setComparator(int type, Object[] obj) {
		comparator.type = type;
		comparator.objs = Arrays.asList(obj);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
