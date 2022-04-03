package gameobjectimpl.test;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.tool.Animators;
import idv.tool.Debug;

public class Test5 {

	public static void main(String[] args) throws IOException {

		Animator animator = Animators.load("David");
		
		Debug.test(animator);
	}

}
