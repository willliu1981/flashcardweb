package responsibilitytest.process;

public class ProcessorBuilder {
	public static class Process {

	}

	private static final ProcessorBuilder instance = new ProcessorBuilder();
	private IProcess currentProcess;
	private IProcess firstProcess;

	private ProcessorBuilder() {
	}

	public static ProcessorBuilder instance() {
		return instance;
	}

	public ProcessorBuilder addProcess(IProcess process) {
		if (this.currentProcess == null) {
			this.currentProcess = firstProcess = process;
		} else {
			this.currentProcess.setNextProcess(process);
			this.currentProcess = process;
		}
		return this;
	}

	public <T extends IProcess> T getFirstProcess() {
		return (T) this.firstProcess;
	}

}
