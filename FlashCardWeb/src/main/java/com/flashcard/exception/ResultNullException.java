package com.flashcard.exception;

import java.io.IOException;

public class ResultNullException extends IOException implements IException {
	private static final long serialVersionUID = 1L;
	private static IExceptionWrap wrap;

	public ResultNullException() {
		this("");
	}

	public ResultNullException(String msg) {
		super("Result is null " + IException.processMsg(msg));

	}

	public ResultNullException(Class<?> Clazz, String methodname, String msg) {
		this(wrap.getMsg(Clazz, methodname, msg));
	}

	@Override
	public void setResultExceptionWrap(IExceptionWrap wrap) {
		ResultNullException.wrap = wrap;
	}

}
