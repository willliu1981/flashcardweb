package test.robot.robot2;

public class RobotFactory {

	static Robot createRobot() {
		Robot robot = new Robot();
		robot.setName("robot1");

		Component spine = new Component();
		spine.setName("spine");

		Component body = new Component();
		body.setName("body");
		body.setRect(0, 0, 100, 150);
		body.setPivot(50, 75);
		body.setPosition(0, -75);
		spine.attachComponent(body);

		Component head = new Component();
		head.setName("head");
		head.setRect(0, 0, 50, 50);
		head.setPivot(25, 25);
		head.setPosition(0, -25);
		body.attachComponent(head);

		Component rHand = new Component();
		rHand.setName("rHand");
		body.attachComponent(rHand);

		Component lHand = new Component();
		lHand.setName("lHand");
		body.attachComponent(lHand);

		Component rfoot = new Component();
		rfoot.setName("rfoot");
		spine.attachComponent(rfoot);

		Component lfoot = new Component();
		lfoot.setName("lfoot");
		spine.attachComponent(lfoot);

		robot.setComponent(spine);
		return robot;
	}

	public static void paintRobot(GameObject robot) {
		if (robot.getComponent().hasChilds() ) {
			System.out.println("xxx1 " + robot.getName());
			//Paints.Paint(robot.getComponent());
			//paintRobot(robot);

		}

	}
}
