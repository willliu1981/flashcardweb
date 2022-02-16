package test1;

public interface IProcess<T, E> {
	void setInnerProcess(IProcess<T,E> processor);

	IProcess<T,E> getInnerProcessor();

	E process(T t);
	
	
}
