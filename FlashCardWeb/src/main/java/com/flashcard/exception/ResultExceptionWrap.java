package com.flashcard.exception;

public class ResultExceptionWrap implements IExceptionWrap {

	@Override
	public String getMsg(Class<?> clazz, String methodName, String msg) {
		String returnMsg = String.format("%s::%s:%s", clazz.getName(), methodName, msg);
		return returnMsg;
	}

}
