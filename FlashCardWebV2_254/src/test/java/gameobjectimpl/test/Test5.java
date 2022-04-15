package gameobjectimpl.test;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.google.common.io.Files;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.tool.Animators;
import idv.tool.Debug;

public class Test5 {

	public static void main(String[] args) throws IOException {

//		Animator animator = Animators.load("David");
//		
//		Debug.test(animator);
		test();
		
		
	}
	
	@Test
	public static void test() {
		int a = 0;
		test2(++a);
		Debug.test("xx", a);
	}

	public static void test2(int value) {
		Debug.test("xx2", value);
	}

}
