package responsibilitytest.process;

public class ProcessBuilder {
	public static class Processor<T> {
		private IProcess<T> process;

		public Processor(ProcessBuilder builder) {
			this.setProcess(builder.firstProcess);
		}

		private void setProcess(IProcess<T> process) {
			this.process = process;
		}

		public void process(T t) {
			process.loopProcess(t);
		}

		protected IProcess<T> getProcess() {
			return this.process;
		}

	}

	public static class Processors {
		public static <T extends IProcess, E extends Processor> void setProcessor(T t,
				E e) {
			IProcess<?> process = t;
			t.setProcessor(e);
			while ((process = t.getNextProcess()) != null) {
				process.setProcessor(e);
				t=(T) process;
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
