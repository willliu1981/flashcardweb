package responsibilitytest.concrete;

import idv.kwl.model.User;
import responsibilitytest.process.Process;

public abstract class UserProcess extends Process<User> {
	enum State {
		YoungRich, ElderRich, Default
	}

	private static State state;

	protected void setState(State state) {
		UserProcess.state = state;
	}

	protected State getState() {
		return UserProcess.state;
	}

}
