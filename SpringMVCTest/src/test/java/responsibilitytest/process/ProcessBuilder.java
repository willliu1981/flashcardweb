package responsibilitytest.process;

public class ProcessBuilder {
	public static class Processor<T> {
		private IProcess<T, Processor<T>> process;

		public Processor(ProcessBuilder builder) {
			this.setProcess(builder.firstProcess);
		}

		private void setProcess(IProcess<T, Processor<T>> process) {
			this.process = process;
		}

		public void process(T t) {
			process.loopProcess(t);
		}

		protected IProcess<T, Processor<T>> getProcess() {
			return this.process;
		}

	}

	public static class Processors {
		public static <T, E extends Processor<T>, U extends IProcess<T, E>> void setProcessor(
				U process, E processor) {
			process.setProcessor(processor);
			IProcess<T, E> next = null;
			while ((next = process.getNextProcess()) != null) {
				next.setProcessor(processor);
				process = (U) next;
			}
		}
	}

	private IProcess currentProcess;
	private IProcess firstProcess;

	private ProcessBuilder() {
	}

	public static ProcessBuilder instance() {
		return new ProcessBuilder();
	}

	public ProcessBuilder addProcess(IProcess process) {
		if (this.currentProcess == null) {
			this.currentProcess = firstProcess = process;
		} else {
			this.currentProcess.setNextProcess(process);
			this.currentProcess = process;
		}
		return this;
	}

}
