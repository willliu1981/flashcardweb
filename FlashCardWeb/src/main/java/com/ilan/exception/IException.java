package com.ilan.exception;

public interface IException {
	public void setResultExceptionWrap(IExceptionWrap wrap);

	static String processMsg(String msg) {
		if (!(msg == null || msg.equals(""))) {
			msg = ": " + msg;
		}
		return msg;
	}
}
