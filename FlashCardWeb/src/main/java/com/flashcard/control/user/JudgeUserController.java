package com.flashcard.control.user;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ilan.control.factory.BeanFactory;
import com.ilan.control.factory.daofactory.DaoFactoryType;
import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.exception.ResultNullException;
import com.ilan.model.user.User;

public class JudgeUserController implements Controller {

	private String viewPage;

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String username = req.getParameter("username");

		IUserDao<User> dao = (IUserDao) BeanFactory.getBean(DaoFactoryType.USERDAO);
		User user = null;
		boolean isExist = true;
		try {
			user = dao.findByUsername(username);
		} catch (ResultNullException | SQLException e) {
			isExist = false;
		}
		
		//res.getWriter().print(isExist);

		return new ModelAndView(this.viewPage, "valid", !isExist);
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}

}
