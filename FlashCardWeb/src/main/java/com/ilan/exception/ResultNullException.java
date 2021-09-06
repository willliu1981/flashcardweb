package com.ilan.exception;

import java.io.IOException;

public class ResultNullException extends IOException implements IResultException {
	private static final long serialVersionUID = 1L;
	private static IResultExceptionWrap wrap;

	public ResultNullException() {
		this("");
	}

	public ResultNullException(String msg) {
		super("Result is null " + IResultException.processMsg(msg));

	}

	public ResultNullException(Class<?> Clazz, String methodname, String msg) {
		this(wrap.getMsg(Clazz, methodname, msg));
	}

	@Override
	public void setResultExceptionWrap(IResultExceptionWrap wrap) {
		ResultNullException.wrap = wrap;
	}

}
