package test3;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import idv.debug.Debug;
import idv.test.TestLog;

public class Test1 extends TestLog {

	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");

		Debug.test(new Object() {
		}, "list", list);
	}

	static class Outer {
		Nested nested;

		Nested getNested() {
			return nested;
		}
	}

	static class Nested {
		Inner inner;

		Inner getInner() {
			return inner;
		}
	}

	static class Inner {
		String foo;

		String getFoo() {
			return foo;
		}
	}

	@Test
	public void test2() {
		Outer outer = new Outer();
		Nested nester = new Nested();
		Inner inner = new Inner();

		outer.nested = nester;
		nester.inner = inner;
		inner.foo = "xxx";

		/* outer = new Outer();*/
		if (outer != null && outer.nested != null
				&& outer.nested.inner != null) {
			System.out.println(outer.nested.inner.foo);
		}

		System.out.println("-------");
		Optional.of(outer).map(Outer::getNested).map(Nested::getInner)
				.map(Inner::getFoo).ifPresent(System.out::println);

		System.out.println("-------");

		resolve(() -> outer.getNested().getInner().getFoo())
				.ifPresent(System.out::println);
	}

	public static <T> Optional<T> resolve(Supplier<T> resolver) {
		try {
			T result = resolver.get();
			return Optional.ofNullable(result);
		} catch (NullPointerException e) {
			return Optional.empty();
		}
	}

	@Test
	public void test3() {
		List<String> list1 = Arrays.asList("语文", "数学", "英语");

		List<String> list2 = Arrays.asList("数学", "英语", "语文");

		// 先排序然后转成string 逗号分隔
		boolean falg = list1.stream().sorted().collect(Collectors.joining())
				.equals(list2.stream().sorted().collect(Collectors.joining()));

		System.out.println(falg);
	}

	@Test
	public void test4() {
		List<String> list1 = new ArrayList<String>();
		list1.add("2");
		list1.add("3");
		list1.add("8");
		list1.add("9");

		List<String> list2 = new ArrayList<String>();
		list2.add("2");
		list2.add("3");
		list2.add("7");
		list2.add("8");
		list2.add("9");
		list2.add("11");

		List<String> intersection = list1.stream()
				.filter(item -> list2.contains(item)).collect(toList());
		System.out.println("---交集 intersection---");
		intersection.parallelStream().forEach(System.out::println);

	}

	static class Book {
		Integer price;

		public Book(Integer price) {
			super();
			this.price = price;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

	}

	@Test
	public void test5() {
		Integer[] is = { 1, 2, 3 };
		Gson g = new Gson();
		String json = g.toJson(is);

		logger.info("json=" + json);

		List<Book> list2 = new ArrayList<Book>();
		list2.add(new Book(200));
		list2.add(new Book(300));
		list2.add(new Book(400));
		list2.add(new Book(500));
		list2.add(new Book(600));

		String collect = list2.stream().map(x -> x.getPrice().toString())
				.collect(Collectors.joining(",","[","]"));

		logger.info(collect);
	}

}
