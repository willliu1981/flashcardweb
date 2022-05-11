package idv.taglib.component.common;

public interface TaglibComponent<T> {



	String getBodyResult();

	String getHeaderResult();

	String getFooterResult();

	void setRenderer(TaglibRenderer<T> renderer);

}
