package test.injection;

public class MenuComparators {
	public static final  int TYPE_RANDOM=1;

	static public void setComparator(AttributeSet set, int getType, Object[] objs) {
		set.setComparator(getType, objs);
	}
	static public void setName(AttributeSet set, String name) {
		set.setName(name);
	}
}
