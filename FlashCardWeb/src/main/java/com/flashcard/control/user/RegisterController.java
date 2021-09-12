package com.flashcard.control.user;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.factory.dao.user.UserDao;
import com.flashcard.factory.dao.user.UserdataDao;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;
import com.ilan.control.authority.Authorities;

public class RegisterController implements Controller {
	private String viewPageSuccess;
	private String viewPageFailure;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("username");
		String displayname = request.getParameter("displayname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		String serial_id = "" + new java.util.Date().getTime();
		String user_id = "uid" + serial_id;
		String userdata_id = "udid" + serial_id;

		boolean isSucceed = true;

		User user = new User();
		user.setU_id(user_id);
		user.setUsername(username);
		user.setPassword(password);
		user.setDisplayName(displayname);
		user.setUserdata_id(userdata_id);
		user.setAuthority(Authorities.toString(Authorities.getDefaultAuthority()));

		UserDao userDao = (UserDao) BeanFactory.getBean(DaoFactoryType.USERDAO);
		if (!userDao.add(user)) {
			isSucceed = false;
		}

		Userdata userdata = new Userdata();
		userdata.setUd_id(userdata_id);
		userdata.setUser_id(user_id);
		userdata.setName(user.getDisplayName());
		userdata.setEmail(email);

		UserdataDao userdataDao = (UserdataDao) BeanFactory.getBean(DaoFactoryType.USERDATADAO);
		try {
			if (!userdataDao.add(userdata)) {
				isSucceed = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();

		if (isSucceed) {
			mv.setViewName(viewPageSuccess);
		} else {
			mv.setViewName(viewPageFailure);
		}

		return mv;
	}

	public void setViewPageSuccess(String viewPageSuccess) {
		this.viewPageSuccess = viewPageSuccess;
	}

	public void setViewPageFailure(String viewPageFailure) {
		this.viewPageFailure = viewPageFailure;
	}

}
