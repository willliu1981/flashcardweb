package test.robot.robot2;

public class Demo {

	public static void main(String[] args) {
		
		
		Robot robot = RobotFactory.createRobot();
		
		RobotDemoView view=new RobotDemoView();
		view.setVisible(true);
		robot.setPosition(0, 0);
		view.addRobot(robot);
		view.repaintRobot();
		
		
	}
	
	

}
