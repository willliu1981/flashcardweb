package com.flashcard.control.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;
import com.flashcard.factory.Factory;

public class LogoutController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.getSession()
				.removeAttribute(Factory.getSessionDefinitionOfName("user"));

		return new ModelAndView(target("target"));
	}

}
