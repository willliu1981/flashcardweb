package responsibilitytest.process;

import responsibilitytest.process.ProcessBuilder.Processor;

public interface IProcess<T, E extends Processor<T>> {
	boolean process(T t);

	void setNextProcess(IProcess<T, E> process);

	IProcess<T, E> getNextProcess();

	void loopProcess(T t);

	void setProcessor(E processor);

	E getProcessor();
}
