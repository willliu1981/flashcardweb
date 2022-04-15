package test5;

import idv.tool.Debug;

public class Test1 {

	public static void main(String[] args) {
		SuperFactory sfactory = new SuperFactory();
		Factory factory = new Factory();

		sfactory.setCar(new Car("xxx"));
		sfactory.setFactory(factory);
		sfactory.setUser(new User("aaa"));

		//Car car = sfactory.getCar();

		//Debug.test(car);
	}

}
