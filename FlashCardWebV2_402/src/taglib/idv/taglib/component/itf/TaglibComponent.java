package idv.taglib.component.itf;

import java.util.function.Function;

import idv.taglib.controlmodel.DefaultHandler;
import idv.taglib.controlmodel.Handler;
import idv.taglib.controlmodel.Result;

public interface TaglibComponent<T> {

	Result getBodyResult();

	Result getHeaderResult();

	Result getFooterResult();

	void setRenderer(TaglibRenderer<T> renderer);

	default Result createResult(Function<Handler, String> rend) {
		DefaultHandler defaultHandler = new DefaultHandler();
		String apply = rend.apply(defaultHandler);
		Result result = new Result();
		result.setHandler(defaultHandler);
		result.setResult(apply);
		return result;
	}

}
