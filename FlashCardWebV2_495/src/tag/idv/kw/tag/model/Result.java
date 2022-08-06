package idv.kw.tag.model;

import idv.kw.tag.itf.Handler;

public class Result {
	private Handler handler;
	private String result;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public String getStrResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
