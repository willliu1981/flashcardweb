package com.flashcard.control.user;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.factory.dao.user.IUserDao;
import com.flashcard.model.user.User;

public class LoginController implements Controller {
	private String viewPageSuccess;
	private String viewPageFailure;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		IUserDao<User> dao = (IUserDao<User>) BeanFactory.getBean(DaoFactoryType.USERDAO);

		User user = null;
		boolean valid = false;
		try {
			valid = (user = dao.identifyUser(username, password)) != null ? true : false;
			request.getSession().setAttribute("user", user);
		} catch (ResultNullException | SQLException e) {
			System.out.println(e.getMessage());
		}

		return send(valid, user);
	}

	protected ModelAndView send(boolean valid, User user) {
		if (valid) {
			return new ModelAndView(viewPageSuccess, "user", user);
		} else {
			return new ModelAndView(viewPageFailure, "userDisplayName", user.getDisplayName());
		}
	}

	public void setViewPageSuccess(String viewPageSuccess) {
		this.viewPageSuccess = viewPageSuccess;
	}

	public void setViewPageFailure(String viewPageFailure) {
		this.viewPageFailure = viewPageFailure;
	}

}
