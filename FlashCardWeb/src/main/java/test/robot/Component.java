package test.robot;

public class Component extends GameObject {

	@Override
	public void attachComponent(Component component) {
		super.attachComponent(component);
		component.setSuperComponent(this);
	}

}
