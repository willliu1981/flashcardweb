package test2;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.control.DefaultHandler;
import idv.taglib.control.Handler;
import idv.taglib.control.Result;

public class Test4 {

	protected Result createResult(Function<Handler, String> rend) {
		DefaultHandler defaultHandler = new DefaultHandler();
		String apply = rend.apply(defaultHandler);
		Result result = new Result();
		result.setHandler(defaultHandler);
		result.setResult(apply);
		return result;
	}

	@Test
	public void Test1() {
		TaglibRenderer<Flashcard> renderer = new TaglibRenderer() {

			@Override
			public String getRenderedHeader(Handler handler) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRenderedBody(Handler handler) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRenderedFooter(Handler handler) {
				// TODO Auto-generated method stub
				return "xxx";
			}



		};
		Result createResult = createResult(x -> renderer.getRenderedFooter(x));
		Debug.test(createResult.getStrResult());

	}
}
