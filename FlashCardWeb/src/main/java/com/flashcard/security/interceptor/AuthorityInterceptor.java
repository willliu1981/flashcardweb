package com.flashcard.security.interceptor;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flashcard.control.ControllerAdapter;
import com.flashcard.control.IController;
import com.flashcard.factory.Factory;
import com.flashcard.model.user.User;
import com.flashcard.security.authority.AdminAuthority;
import com.flashcard.security.authority.AuthorityFactory;

public class AuthorityInterceptor extends HandlerInterceptorAdapter
		implements ControllerAdapter {

	private Properties names = new Properties();

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle..........");

		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle..........");
		HttpSession sess = request.getSession(false);
		if (sess == null) {
			return false;
		} else {
			User user = (User) sess
					.getAttribute(Factory.getSessionName("user"));
			return AuthorityFactory.hasKey(user.getAuthority(), name("admin"),
					AdminAuthority.USER);

		}
	}

	@Override
	public void setNames(Properties name) {
		this.names = name;
	}

	@Override
	public String name(String name) {
		return this.names.getProperty(name);
	}

}
