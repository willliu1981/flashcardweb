package com.flashcard.control.account;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.flashcard.dao.user.UserDao;
import com.flashcard.dao.user.UserdataDao;
import com.flashcard.factory.BeanFactory;
import com.flashcard.factory.dao.DaoFactoryType;
import com.flashcard.model.user.User;
import com.flashcard.model.user.Userdata;

public class RegisterController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		user.setAuthority(name("valueDefaultAuthority"));

		UserDao userDao = (UserDao) BeanFactory.getBean(DaoFactoryType.USERDAO);
		if (!userDao.add(user)) {
			isSucceed = false;
		}

		Userdata userdata = new Userdata();
		userdata.setUd_id(userdata_id);
		userdata.setUser_id(user_id);
		userdata.setName(user.getDisplayName());
		userdata.setEmail(email);

		UserdataDao userdataDao = (UserdataDao) BeanFactory
				.getBean(DaoFactoryType.USERDATADAO);
		try {
			if (!userdataDao.add(userdata)) {
				isSucceed = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();

		if (isSucceed) {
			mv.setViewName(target("success"));
		} else {
			mv.setViewName(target("failure"));
		}

		return mv;
	}

}
