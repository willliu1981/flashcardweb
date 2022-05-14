package test2;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.taglib.component.itf.TaglibRenderer;
import idv.taglib.control.DefaultHandler;
import idv.taglib.control.Handler;
import idv.taglib.control.Result;
import idv.test.TestLog;

public class Test4 extends TestLog {

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

	@Test
	public void test2() {

		Integer[] is = { 1, 2, 3 };
		String[] ss = { "a","b","c" };
		
		//IntStream stream = Arrays.stream(is);

		//Arrays.stream(is).forEach(x -> System.out.println("xxx " + x));

		this.foreach(ss);

		logger.info(sb.toString());

	}
}
