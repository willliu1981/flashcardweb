package responsibilitytest.process;

public abstract class Process<T> implements IProcess<T> {
	private IProcess nextProcess;

	@Override
	public void setNextProcess(IProcess processor) {
		this.nextProcess = processor;
	}

	@Override
	public IProcess getNextProcess() {
		return this.nextProcess;
	}

	@Override
	public void loopProcess(T t) {
		if (!this.process(t)) {
			this.nextProcess.loopProcess(t);
		}
	}

	public <T extends IProcess> T create(ProcessorBuilder builder) {

		return null;
	}

}
