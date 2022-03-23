package test7;

public class Test {

	public static void main(String[] args) {

		Car car = new Car();

		CarI carProxy = (CarI) new ProxyUtil(car).getProxy();

		carProxy.setName("X1");

	}

}
