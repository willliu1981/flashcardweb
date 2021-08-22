package com.ilan.exception;

import java.io.IOException;

public class ResultNullException extends  IOException  {
	
	public ResultNullException() {
		super("Result is null");
	}
	public ResultNullException(String msg) {
		super("Result is null:"+msg);
	}

}
