package gameobjectimpl.control;

import java.awt.Point;
import java.util.Date;

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
			rate = (int) (100 * Math.random());
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
		Debug.test("start...");
		animatorControl = this.getOwner().getAnimatorControl();
		animatorControl.setCurrentAnimatorId("walk-right");
		this.currentAction = Action.WALK_RIGHT;
		inputPlatform.setDirection(1);
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

			if (this.currentActionPeriod + this.primeTime < new Date().getTime()) {
				this.currentActionPeriod = (int) (500 + 2000 * Math.random());
				Rater rater = RaterFactory.getRater();

				if (RaterFactory.isRate(rater, 10)) {
					this.currentAction = Action.IDLE;
					Debug.test("reset", "idle");
				} else if (RaterFactory.isRate(rater, 55)) {
					this.currentAction = Action.WALK_RIGHT;
					Debug.test("reset", "right");
				} else if (RaterFactory.isRate(rater, 100)) {
					this.currentAction = Action.WALK_LEFT;
					Debug.test("reset", "left");
				}

				this.primeTime = new Date().getTime();
				this.isActive = false;

			}

			if (!this.isActive) {
				animatorControl.setCurrentAnimatorId("idle");
				inputPlatform.setDirection(0);
				this.isActive = true;
			}
			break;
		case WALK_RIGHT:

			if (this.target.getX() > this.screenSize.x - targetSize.x - 100) {
				setActionForIdleDueToOutOfBounds();

			}

			if (this.currentActionPeriod + this.primeTime < new Date().getTime()) {
				setActionDueToFinshFromWalkRightOrWalkLeft();
			}

			if (!this.isActive) {
				animatorControl.setCurrentAnimatorId("walk-right");
				inputPlatform.setDirection(1);
				this.isActive = true;
			}

			break;
		case WALK_LEFT:
			if (this.target.getX() < 100) {
				setActionForIdleDueToOutOfBounds();
			}

			if (this.currentActionPeriod + this.primeTime < new Date().getTime()) {
				setActionDueToFinshFromWalkRightOrWalkLeft();
			}

			if (!this.isActive) {
				animatorControl.setCurrentAnimatorId("walk-left");
				inputPlatform.setDirection(-1);
				this.isActive = true;
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
	public void setActionForIdleDueToOutOfBounds() {
		this.currentAction = Action.IDLE;
		this.primeTime = new Date().getTime();
		this.currentActionPeriod = (int) (Math.random() * 800 + 200);
		this.isActive = false;
	}

	public void setActionDueToFinshFromWalkRightOrWalkLeft() {
		Rater rater = RaterFactory.getRater();
		if (RaterFactory.isRate(rater, 80)) {
			this.currentAction = Action.IDLE;
			Debug.test("from finsh(Right/Left)", "idle");
		} else if (RaterFactory.isRate(rater, 90)) {
			this.currentAction = Action.WALK_RIGHT;
			Debug.test("from finsh(Right/Left)", "right");
		} else if (RaterFactory.isRate(rater, 100)) {
			this.currentAction = Action.WALK_LEFT;
			Debug.test("from finsh(Right/Left)", "left");
		}

		this.primeTime = new Date().getTime();
		this.currentActionPeriod = (int) (Math.random() * 500 + 2000);
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
