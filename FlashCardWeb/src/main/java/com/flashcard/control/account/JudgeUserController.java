package com.flashcard.control.account;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.flashcard.dao.user.IUserDao;
import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;

public class JudgeUserController implements Controller {

	private String keyValid = "valid";
	private String valueValid = "true";
	private String valueInvalid = "false";

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String username = req.getParameter("username");

		IUserDao<User> dao = (IUserDao) BeanFactory.getBean(DaoFactoryType.USERDAO);
		String valid = valueInvalid;
		try {
			dao.findByUsername(username);
		} catch (ResultNullException | SQLException e) {
			valid = valueValid;
		}
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.addObject(this.keyValid, valid);

		return mv;
	}

	public void setKeyValid(String keyValid) {
		this.keyValid = keyValid;
	}

	public void setValueValid(String valueValid) {
		this.valueValid = valueValid;
	}

	public void setValueInvalid(String valueInvalid) {
		this.valueInvalid = valueInvalid;
	}

}