package responsibilitytest.process;

import responsibilitytest.process.ProcessBuilder.Processor;

public interface IProcess<T> {
	boolean process(T t);

	void setNextProcess(IProcess process);

	IProcess getNextProcess();
	
	void loopProcess(T t);
	
	 void setProcessor(Processor<?> processor) ;
}
