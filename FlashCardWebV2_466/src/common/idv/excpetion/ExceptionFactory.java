package idv.excpetion;

public class ExceptionFactory {

	public static UnsupportedOperationException getDefaultUnsupportedOperationException(
			Object enclosingObject) {

		return new MyUnsupportedOperationException(
				enclosingObject.getClass().getEnclosingMethod() + " 方法尚未實作");
	}

}
