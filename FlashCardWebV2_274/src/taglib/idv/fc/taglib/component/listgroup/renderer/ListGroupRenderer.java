package idv.fc.taglib.component.listgroup.renderer;

public interface ListGroupRenderer<T> {
	static String SKIP = "rtn_skip";


	String getRenderedAfter(T model);

	String getRenderedBefore();

	String getRenderedResult(T model);
}
