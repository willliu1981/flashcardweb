package responsibilitytest.process;

import responsibilitytest.process.ProcessBuilder.Processors;

public class ProcessBuilder {
	public static class Processor<T> {
		private IProcess<T, Processor<T>> process;
		private Object object;

		public Object getObject() {
			return object;
		}

		public void setObject(Object object) {
			this.object = object;
		}

		public Processor(ProcessBuilder builder) {
			this.setProcess(builder.firstProcess);
			Processors.setProcessor(this.getProcess(), this);
		}

		private void setProcess(IProcess<T, Processor<T>> process) {
			this.process = process;
		}

		public Object process(T t) {
			process.loopProcess(t);
			return this.object;
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
