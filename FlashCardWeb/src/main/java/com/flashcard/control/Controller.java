package com.flashcard.control;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public abstract class Controller
		implements org.springframework.web.servlet.mvc.Controller {
	protected Properties session;
	protected Properties target;
	protected Properties name;

	public void setSessions(Properties session) {
		this.session = session;
	}

	public void setTargets(Properties target) {
		this.target = target;
	}

	public void setNames(Properties name) {
		this.name = name;
	}

	public String session(String name) {
		return session.getProperty(name);
	}

	public String target(String name) {
		return target.getProperty(name);
	}

	public String name(String name) {
		return this.name.getProperty(name);
	}

}
