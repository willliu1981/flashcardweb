package gameobjectimpl.control;

import java.awt.Point;
import java.util.Date;
import java.util.Random;

import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;

public class TestGameController extends GameControllerAdapter {
	Point screenSize;
	static Point targetSize = new Point(600, 900);
	InputPlatformImpl inputPlatform;
	GameObject target;
	HasAnimation targetWithAnimatorControl;
	AnimatorControl animatorControl;
	static Random rnd;

	int currentActionPeriod;
	long primeTime;
	Action currentAction;
	boolean isActive;//action 是否已啟動

	enum Action {
		WALK_RIGHT, WALK_LEFT, IDLE, NOTHING
	}

	static class Rater {
		int rate;

		void reset() {

		}

		void start() {
			rate = rnd.nextInt(100);
		}

		int getRate() {
			return this.rate;
		}
	}

	static class RaterFactory {
		static Rater getRater() {
			Rater rater = new Rater();
			rater.start();
			return rater;
		}

		static boolean isRate(Rater rater, int expectedRate) {
			return rater.getRate() < expectedRate;
		}
	}

	@Override
	public void start() {
		//Debug.test("start...");
		rnd = new Random();
		animatorControl = this.getOwner().getAnimatorControl();
		animatorControl.setCurrentAnimatorId("idle");
		this.currentAction = Action.IDLE;
		inputPlatform.setDirection(0);
		this.primeTime = new Date().getTime();
	}

	@Override
	public void update() {

		/*
		 *  時間到,重設狀態
		 */

		//*
		switch (this.currentAction) {

		case IDLE:
			if (!this.isActive) {
				animatorControl.setCurrentAnimatorId("idle");
				inputPlatform.setDirection(0);
				this.isActive = true;
			}

			if (this.currentActionPeriod + this.primeTime < new Date().getTime()) {
				this.currentActionPeriod = rnd.nextInt(10) * 300 + 1000;
				Rater rater = RaterFactory.getRater();

				if (RaterFactory.isRate(rater, 10)) {
					this.currentAction = Action.IDLE;
				} else if (RaterFactory.isRate(rater, 55)) {
					this.currentAction = Action.WALK_RIGHT;
				} else if (RaterFactory.isRate(rater, 100)) {
					this.currentAction = Action.WALK_LEFT;
				}

				this.primeTime = new Date().getTime();
				this.isActive = false;

			}

			break;
		case WALK_RIGHT:
			if (!this.isActive) {
				animatorControl.setCurrentAnimatorId("walk-right");
				inputPlatform.setDirection(1);
				this.isActive = true;
			}

			if (getOutOfBoundsDir() > 0) {
				setActionForIdleDueToOutOfBounds(1);

			}

			if (this.currentActionPeriod + this.primeTime < new Date().getTime()) {
				setActionDueToFinshFromWalkRightOrWalkLeft();
			}

			break;
		case WALK_LEFT:
			if (!this.isActive) {
				animatorControl.setCurrentAnimatorId("walk-left");
				inputPlatform.setDirection(-1);
				this.isActive = true;
			}

			if (getOutOfBoundsDir() < 0) {
				setActionForIdleDueToOutOfBounds(-1);

			}

			if (this.currentActionPeriod + this.primeTime < new Date().getTime()) {
				setActionDueToFinshFromWalkRightOrWalkLeft();
			}

			break;

		default:

			break;
		}
		//*/

	}

	/*
	 * 超出邊界
	 */
	public void setActionForIdleDueToOutOfBounds(int fromDir) {
		Rater rater = RaterFactory.getRater();

		if (RaterFactory.isRate(rater, 20)) {
			this.currentAction = Action.IDLE;
		} else {
			if (fromDir > 0) {
				this.currentAction = Action.WALK_LEFT;
			} else {
				this.currentAction = Action.WALK_RIGHT;
			}

		}

		this.primeTime = new Date().getTime();
		this.currentActionPeriod = rnd.nextInt(10) * 70 + 300;
		this.isActive = false;
	}

	public int getOutOfBoundsDir() {
		if (this.target.getX() > this.screenSize.x - targetSize.x) {
			return 1;

		}

		if (this.target.getX() < 0) {
			return -1;
		}

		return 0;
	}

	public void setActionDueToFinshFromWalkRightOrWalkLeft() {
		Rater rater = RaterFactory.getRater();
		if (RaterFactory.isRate(rater, 80)) {
			this.currentAction = Action.IDLE;
		} else if (RaterFactory.isRate(rater, 90)) {
			this.currentAction = Action.WALK_RIGHT;
		} else if (RaterFactory.isRate(rater, 100)) {
			this.currentAction = Action.WALK_LEFT;
		}

		this.primeTime = new Date().getTime();
		this.currentActionPeriod = rnd.nextInt(10) * 100 + 1000;
		this.isActive = false;
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

}
