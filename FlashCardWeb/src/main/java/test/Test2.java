package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		/*
		list.add("A");
		list.add("B");
		list.add("C");
		//*/
		String s = list.stream().findAny().orElse("-");

		System.out.println("xxx " + s);

	}

}
