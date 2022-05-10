package idv.fc.taglib.component.common;

public interface TaglibRenderer<T> extends Renderable {
	static String EMPTY = "";

	String getRenderedHeader();

	String getRenderedBody();

	String getRenderedFooter();
}
