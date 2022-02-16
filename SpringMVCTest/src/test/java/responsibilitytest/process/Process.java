package responsibilitytest.process;

import responsibilitytest.process.ProcessBuilder.Processor;

public abstract class Process<T, E extends Processor<T>> implements IProcess<T, E> {
	private IProcess<T, E> nextProcess;
	private E processor;

	@Override
	public void setProcessor(E processor) {
		this.processor = processor;
	}

	@Override
	public E getProcessor() {
		return this.processor;
	}

	@Override
	public void setNextProcess(IProcess<T, E> processor) {
		this.nextProcess = processor;
	}

	@Override
	public IProcess<T, E> getNextProcess() {
		return this.nextProcess;
	}

	@Override
	public void loopProcess(T t) {
		if (!this.process(t)) {
			this.nextProcess.loopProcess(t);
		}
	}

}
