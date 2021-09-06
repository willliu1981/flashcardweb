package com.ilan.exception;

public interface IResultException {
	public void setResultExceptionWrap(IResultExceptionWrap wrap);

	static String processMsg(String msg) {
		if (!(msg == null || msg.equals(""))) {
			msg = ": " + msg;
		}
		return msg;
	}
}
