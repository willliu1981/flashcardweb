package test4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class Test3 {

	@Test
	public void test1() {
		//A1
		//*
		System.out.println("A1:");
		new Random().ints(10).boxed().sorted(Collections.reverseOrder())
				.forEach(System.out::println);//*/

		//A2
		Integer nums[] = new Integer[10];

		for (int i = 0; i < 10; i++) {
			nums[i] = (int) (Math.random() * Integer.MAX_VALUE * 2
					+ Integer.MIN_VALUE);
		}

		//*
		System.out.println("-------------");
		System.out.println("A2:");
		Arrays.stream(nums).sorted(Collections.reverseOrder()).forEach(System.out::println);//*/


	}
}
