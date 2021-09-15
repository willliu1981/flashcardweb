package com.flashcard.control.account;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public abstract class Controller
		implements org.springframework.web.servlet.mvc.Controller {
	protected Properties name;

	public void setSetName(Properties name) {
		this.name = name;
	}

	public String name(String name) {
		return this.name.getProperty(name);
	}

}
