package gameobjectimpl.control;

public interface GameControlI extends ScriptI {
	public void start();

	public void update();

	public boolean isStarted();

	@Override
	default void execute() {
		if (!this.isStarted()) {
			this.start();
		}

		this.update();

	}

}
