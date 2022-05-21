package test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

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

}
