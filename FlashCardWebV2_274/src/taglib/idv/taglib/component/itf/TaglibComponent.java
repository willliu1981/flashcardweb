package idv.taglib.component.itf;

public interface TaglibComponent<T> {



	String getBodyResult();

	String getHeaderResult();

	String getFooterResult();

	void setRenderer(TaglibRenderer<T> renderer);

}
