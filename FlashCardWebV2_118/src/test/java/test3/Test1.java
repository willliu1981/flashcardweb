package test3;

import idv.fc.model.User;
import idv.fc.tool.Debug;

public class Test1 {

	public static class Car {
		private String name;
		private User driverUser;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public User getDriverUser() {
			return driverUser;
		}

		public void setDriverUser(User driverUser) {
			this.driverUser = driverUser;
		}

		public void run() {
			System.out.println(
					this.driverUser.getDisplay_name() + " run the " + this.name);
		}

	}

	public static void main(String[] args) {
		User user = new User();
		user.setDisplay_name("David");
		user.setAge(17);

		Car car = new Car();

		ProxyFactory factory = new ProxyFactory();

		UserInterceptor icCar = new UserInterceptor();
		icCar.setTarget(car);

		Car carProxy = (Car) factory.getProxyInstance(icCar);
		carProxy.setName("Volvo");
		carProxy.setDriverUser(user);

		carProxy.run();

	}

}
