package responsibilitytest.concrete.user;

import idv.kwl.model.User;
import responsibilitytest.concrete.user.UserProcessor.State;
import responsibilitytest.process.Process;

public abstract class UserProcess extends Process<User, UserProcessor> {

	protected void setState(State state) {
		this.getProcessor().setState(state);
	}

	protected State getState() {
		return this.getProcessor().getState();
	}

}
