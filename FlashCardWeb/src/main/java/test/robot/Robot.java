package test.robot;

import java.awt.Point;
import java.util.List;

public class Robot extends GameObject {
	String name;
	Component spine;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Component getSpine() {
		return spine;
	}

	public void setSpine(Component spine) {
		this.spine = spine;
	}

	@Override
	public Component getComponent() {
		return this.spine;
	}

	@Override
	public Component getSuperComponent() {
		return this.spine;
	}

	@Override
	public List<Component> getAttachs() {
		return this.spine.getAttachs();
	}

	@Override
	public boolean hasChilds() {
		return this.spine.hasChilds();
	}

	@Override
	public Point getAbsolute() {
		return this.getAbsolute();
	}

}
