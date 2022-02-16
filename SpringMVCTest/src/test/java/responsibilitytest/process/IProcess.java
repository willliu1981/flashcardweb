package responsibilitytest.process;

public interface IProcess<T> {
	boolean process(T t);

	void setNextProcess(IProcess process);

	IProcess getNextProcess();
	
	void loopProcess(T t);
}
