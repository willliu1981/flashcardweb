package gameobjectimpl.control;

import java.awt.Point;

import idv.tool.Debug;

public class InputPlatformImpl extends InputPlatform {
	static Point targetSize = new Point(300, 900);
	int distance = 20;

	@Override
	public void init() {
		this.target.setX(200);
	}

	@Override
	public void start() {

	}

	@Override
	public void update() {

		//Debug.test("ip", dir);
		this.target.setX(this.target.getX() + dir * distance);

	}

}
