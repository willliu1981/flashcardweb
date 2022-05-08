package idv.fc.taglib.component.common;

public interface TaglibRenderer<T> {
	static String EMPTY = "";

	String getRenderedTitle();

	String getRenderedBody();

	String getRenderedFooter();
}
