package gameobjectimpl.control;

public interface GameControlI extends ScriptI {
	public void init();
	
	public void start();

	public void update();

	public boolean isStarted();

	@Override
	default void execute() {
		if (!this.isStarted()) {
			this.init();
			this.start();
		}

		this.update();

	}

}
