package responsibilitytest.concrete;

import idv.kwl.model.User;
import responsibilitytest.concrete.UserProcessor.State;

public class DefaultProcess extends UserProcess {

	@Override
	public boolean process(User t) {
		this.setState(State.Default);
		return true;
	}

}
