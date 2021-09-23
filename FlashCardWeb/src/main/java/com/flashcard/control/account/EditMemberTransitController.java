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

public class EditMemberTransitController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView();
		String uid = request.getParameter(name("id"));
		if (uid != null) {
			IUserDao<User> userDao = (IUserDao<User>) BeanFactory
					.getBean(DaoFactoryType.USERDAO);
			IUserdataDao<Userdata> userdataDao = (IUserdataDao<Userdata>) BeanFactory
					.getBean(DaoFactoryType.USERDATADAO);

			User user = userDao.queryByID(uid);
			Userdata userdata = userdataDao.queryByID(user.getUserdata_id());

			mv.addObject(name("user"), user);
			mv.addObject(name("userdata"), userdata);

			mv.addObject(name("isAdmin"), true);
			//mv.setViewName(target("withAdmin"));
		} else {
			mv.addObject(name("isAdmin"), false);
		}
		mv.setViewName(target("member"));
		return mv;
	}

}
