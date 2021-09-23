package com.flashcard.control.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;
import com.flashcard.dao.user.IUserDao;
import com.flashcard.dao.user.IUserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.Factory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;

public class EditMemberWithAdminController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String displayName = request.getParameter(name("displayName"));
		String password = request.getParameter(name("password"));
		String email = request.getParameter(name("email"));
		boolean isAdmin = Boolean
				.parseBoolean(request.getParameter(name("isAdmin")));
		String uid = request.getParameter(name("uid"));

		IUserDao<User> userDao = (IUserDao<User>) BeanFactory
				.getBean(DaoFactoryType.USERDAO);
		IUserdataDao<Userdata> userdataDao = (IUserdataDao<Userdata>) BeanFactory
				.getBean(DaoFactoryType.USERDATADAO);

		User user = null;
		if (isAdmin) {
			user = userDao.queryByID(uid);
		} else {
			user = (User) request.getSession()
					.getAttribute(Factory.getSessionDefinitionOfName("user"));
		}

		Userdata userdata = userdataDao.queryByID(user.getUserdata_id());

		user.setDisplayName(displayName);
		user.setPassword(password);

		userdata.setName(displayName);
		userdata.setEmail(email);

		boolean r = true;
		try {
			if (userDao.update(user.getU_id(), user) == 0) {
				r = false;
			}

			if (userdataDao.update(userdata.getUd_id(), userdata) == 0) {
				r = false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView mv = new ModelAndView();
		if (r) {

			if (!isAdmin) {
				request.getSession().setAttribute(
						Factory.getSessionDefinitionOfName("user"), user);
			}
			mv.setViewName(target("success"));
		} else {
			mv.setViewName(target("failure"));
		}

		return mv;
	}

}
