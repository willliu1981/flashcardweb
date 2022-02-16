package responsibilitytest.concrete;

import idv.kwl.model.User;
import responsibilitytest.process.ProcessBuilder;
import responsibilitytest.process.ProcessBuilder.Processor;
import responsibilitytest.process.ProcessBuilder.Processors;

public class UserProcessor extends Processor<User> {

	public enum State {
		YoungRich, ElderRich, Default
	}

	private State state;

	public UserProcessor(ProcessBuilder builder) {
		super(builder);

		Processors.setProcessor(this.getProcess(), this);
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}

}
