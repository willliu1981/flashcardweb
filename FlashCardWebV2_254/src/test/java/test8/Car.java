package test8;

import idv.fc.proxy.ProxyFactory;

public class Car extends Product {
	static int number;
	String name;

	public void add() {
		number++;
		System.out.println(number);
		
	}

	@Override
	String getName() {
		return this.name;
	}

}
