package test5;

public class SuperFactory {
	Factory factory;
	Car car;
	User user;

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

//	public Car getCar() {
//		factory.setUser(user);
//		factory.setCar(car);
//		return factory.getCar();
//	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
