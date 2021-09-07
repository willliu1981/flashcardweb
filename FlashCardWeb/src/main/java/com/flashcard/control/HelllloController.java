package com.flashcard.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelllloController implements Controller {

	private String viewPage;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
			throws Exception {
		String msg = arg0.getParameter("msg");

		return new ModelAndView(this.viewPage, "msgg", msg + " xxx");
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}

}
