package test4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import idv.test.TestLog;

public class Test extends TestLog {

	public static void main(String[] args) {

		String[] colors = { "blue", "red", "green", "yellow", "orange" };
		String a = "";

		Stream<String> colorsStream = Arrays.stream(colors);

		Set<String> querys = new HashSet<>();
		querys.add("red");
		querys.add("green");
		querys.add("orange");

		a = colorsStream.filter(c -> querys.contains(c))
				.collect(Collectors.joining("/"));

		System.out.println(a);
	}

}
