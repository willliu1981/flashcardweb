package idv.fc.taglib.component.common;

public interface TaglibRenderer<T> {
	static String EMPTY = "";

	String getRenderedHeader();

	String getRenderedBody();

	String getRenderedFooter();
}
