package gameobjectimpl.control;

import java.awt.Point;

import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import idv.tool.Debug;

public class TestGameController extends GameControllerAdapter {
	Point screenSize;
	static Point targetSize = new Point(600, 900);
	InputPlatformImpl inputPlatform;
	GameObject target;
	HasAnimation targetWithAnimatorControl;
	AnimatorControl animatorControl;
	private static int dir = -1;

	@Override
	public void start() {
		Debug.test("start...");
		animatorControl = this.getOwner().getAnimatorControl();
		animatorControl.setCurrentAnimatorId("walk-right");
		inputPlatform.setDirection(1);
	}

	@Override
	public void update() {

		//*
		switch (animatorControl.getCurrentAnimatorId()) {

		case "idle":

			break;
		case "walk-right":
			if (this.target.getX() > this.screenSize.x - targetSize.x) {
				animatorControl.setCurrentAnimatorId("walk-left");
				inputPlatform.setDirection(-1);
			}
			break;
		case "walk-left":

			if (this.target.getX() < 10) {
				animatorControl.setCurrentAnimatorId("walk-right");
				inputPlatform.setDirection(1);
			}
			break;

		default:

			break;
		}
		//*/

	}

	public void setInputPlatform(InputPlatformImpl inputPlatform) {
		this.inputPlatform = inputPlatform;
	}

	public void setTarget(GameObject target) {
		this.target = target;
	}

	public void setTargetWithAnimatorControl(HasAnimation targetWithAnimatorControl) {
		this.targetWithAnimatorControl = targetWithAnimatorControl;
	}

	public void setScreenSize(Point screenSize) {
		this.screenSize = screenSize;
	}

	//	public static void move() {
	//		List<Component> gameObjects = Scene.getSceneComponents();
	//		gameObjects.forEach(go -> {
	//			Point p = go.getRelevantPosition();
	//
	//			switch (dir) {
	//			case 1:
	//				p.x = p.x + 25;
	//				break;
	//			case -1:
	//				p.x = p.x - 25;
	//				break;
	//			default:
	//				break;
	//			}
	//
	//			if (p.x > 800) {
	//				dir = -1;
	//			} else if (p.x < 50) {
	//				dir = 1;
	//			}
	//			go.setRelevantPosition(p);
	//		});
	//
	//	}

}
