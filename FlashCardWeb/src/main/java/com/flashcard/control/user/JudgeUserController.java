package com.flashcard.control.user;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.factory.dao.user.IUserDao;
import com.flashcard.model.user.User;

public class JudgeUserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String username = req.getParameter("username");

		IUserDao<User> dao = (IUserDao) BeanFactory.getBean(DaoFactoryType.USERDAO);
		String valid = "false";
		try {
			dao.findByUsername(username);
		} catch (ResultNullException | SQLException e) {
			valid = "true";
		}
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.addObject("valid", valid);

		return mv;
	}

}
