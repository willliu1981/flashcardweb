package test1;

import java.util.List;
import java.util.Map;

import idv.kwl.model.User;

public abstract class AbsProcessor implements IProcess<List<User>, List<User>> {

	private IProcess<List<User>, List<User>> innerProcessor;

	public void setInnerProcess(IProcess<List<User>, List<User>> processor) {
		this.innerProcessor = processor;
	}

	public IProcess<List<User>, List<User>> getInnerProcessor() {
		return this.innerProcessor;
	}

	public List<User> loopProcess(List<User> t) {
		List<User> users = null;
		if ((users = this.process(t)).isEmpty()) {
			if (this.innerProcessor == null) {
				throw new RuntimeException(
						this.getClass() + ":chain error, innerProcessor is null");
			}
			users = this.innerProcessor.process(t);
		}

		return users;
	}

	@Override
	public String toString() {
		return this.getClass() + ": AbsProcessor [innerProcessor=" + innerProcessor
				+ "]";
	}

}
