package idv.excpetion;

public class MyUnsupportedOperationException
		extends UnsupportedOperationException {

	public MyUnsupportedOperationException() {

	}

	public MyUnsupportedOperationException(String msg) {
		super(msg);
	}
}
