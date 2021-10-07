package test.robot;

public class Demo {

	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.setName("robot1");
		
		Component spine = new Component();
		spine.setName("spine");

		Component body = new Component();
		body.setName("body");
		spine.attachComponent(body);

		Component head = new Component();
		head.setName("head");
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
		
		robot.setSpine(spine);
		
		

	}
}
