package idv.fc.taglib.component.common;

public interface TaglibComponent<T> {

	String getBodyResult(int index);

	String getTitleResult();

	String getFooterResult();

	void setRenderer(TaglibRenderer<T> renderer);

}
