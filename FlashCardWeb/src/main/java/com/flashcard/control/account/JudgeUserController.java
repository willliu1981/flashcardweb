package com.flashcard.control.account;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.flashcard.control.Controller;
import com.flashcard.dao.user.IUserDao;
import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;

public class JudgeUserController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String username = req.getParameter(name("username"));

		IUserDao<User> dao = (IUserDao) BeanFactory
				.getBean(DaoFactoryType.USERDAO);
		String valid = name("false");
		try {
			dao.findByUsername(username);
		} catch (ResultNullException e) {
			valid = name("true");
		}
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.addObject(name("valid"), valid);

		return mv;
	}

}
