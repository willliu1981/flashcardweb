package gameobject;

import java.awt.Point;

import idv.tool.Debug;

public class GameObjectDemo {

	public static void main(String[] args) {

		GameObject spine = new GameObject();
		spine.setLayer(21);
		spine.setName("spine");
		spine.setRelevantPosition(new Point(100, 300));

		GameObject head = new GameObject();
		head.setLayer(22);
		head.setName("head");
		head.setRelevantPosition(new Point(0, -200));

		spine.addComponent(head);

		Scene sc = new Scene();
		sc.addComponent(spine);

		Debug.test("before...");
		Debug.test("head", head);
		Debug.test("spine", spine);

		sc.locating();

		Debug.test("after...");
		Debug.test("head", head);
		Debug.test("spine", spine);

	}

}
