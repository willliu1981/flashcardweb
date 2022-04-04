package gameobjectimpl.test;

import java.util.ArrayList;
import java.util.List;

import gameobjectimpl.animator.Animator.KeyFrame;
import idv.tool.Debug;

public class Test6 {

	public static void main(String[] args) {
		KeyFrame key1 = new KeyFrame();
		key1.setKeyName("a");
		key1.setKeyIndex(0);

		KeyFrame key2 = new KeyFrame();
		key2.setKeyName("a");
		key2.setKeyIndex(0);

		List<KeyFrame> list = new ArrayList<>();
		list.add(key1);
		
		boolean res=list.contains(key2);
		
		Debug.test(res);

	}

}
