package responsibilitytest.concrete;

import idv.kwl.model.User;
import responsibilitytest.concrete.UserProcessor.State;
import responsibilitytest.process.Process;
import responsibilitytest.process.ProcessBuilder.Processor;

public abstract class UserProcess extends Process<User> {

	private UserProcessor processor;

	protected void setState(State state) {
		processor.setState(state);
	}

	protected State getState() {
		return processor.getState();
	}

	@Override
	public void setProcessor(Processor<?> processor) {
		this.processor = (UserProcessor) processor;
	}

}
