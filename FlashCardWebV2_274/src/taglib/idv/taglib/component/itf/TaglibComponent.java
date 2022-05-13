package idv.taglib.component.itf;

import idv.excpetion.MyUnsupportedOperationException;
import idv.taglib.control.Result;

public interface TaglibComponent<T> {

	Result getBodyResult();

	Result getHeaderResult();

	Result getFooterResult();

	default Result getFooterResult2() {
		throw new MyUnsupportedOperationException(
				new Object().getClass().getEnclosingMethod() + " 方法尚未實作");
	}

	void setRenderer(TaglibRenderer<T> renderer);

}
