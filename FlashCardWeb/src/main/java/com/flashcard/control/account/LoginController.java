package com.flashcard.control.account;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;
import com.flashcard.dao.user.IUserDao;
import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.Factory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;

public class LoginController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter(name("username"));
		String password = request.getParameter(name("password"));

		IUserDao<User> dao = (IUserDao<User>) BeanFactory
				.getBean(DaoFactoryType.USERDAO);

		User user = null;
		boolean valid = false;
		try {
			valid = (user = dao.identifyUser(username, password)) != null ? true
					: false;
			request.getSession().setAttribute(Factory.getSessionName("user") , user);
		} catch (ResultNullException | SQLException e) {
			request.getSession().invalidate();
			System.out.println(e.getMessage());
		}

		if (valid) {
			return new ModelAndView(target("success"));
		} else {
			return new ModelAndView(target("failure"));
		}
	}

}
