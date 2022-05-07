package idv.fc.taglib.component.listgroup.renderer;

public interface ListGroupRenderer<T> {
	static String SKIP="rtn_skip";

	String getRenderedBefore(T model);

	String getRenderedResult(T model);

	String getRenderedAfter(T model);
}
