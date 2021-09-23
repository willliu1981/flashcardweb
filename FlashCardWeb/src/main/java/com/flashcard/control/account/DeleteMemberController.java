package com.flashcard.control.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;
import com.flashcard.dao.user.IUserDao;
import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;

public class DeleteMemberController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String id = request.getParameter(name("uid"));
		IUserDao<User> userDao = (IUserDao<User>) BeanFactory
				.getBean(DaoFactoryType.USERDAO);
		IUserdataDao<Userdata> userdataDao = (IUserdataDao<Userdata>) BeanFactory
				.getBean(DaoFactoryType.USERDATADAO);

		User user = userDao.queryByID(id);

		boolean r = userDao.delete(id) >= 1 ? true : false;

		ModelAndView mv = new ModelAndView();

		if (r) {
			mv.setViewName(target("success"));
		} else {
			mv.setViewName(target("failure"));
		}

		return mv;
	}

}
