package idv.fc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;
import idv.fc.model.UserFake;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	@Qualifier("UserCommonDao")
	private Dao<User> userCommonDao;

	/**
	 * toXXX 表示轉發,以下類推
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String toLogin(User user) {
		return "user/login";
	}

	@RequestMapping(value = "toQuery", method = RequestMethod.GET)
	public String toQuery() {
		return "test/test";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserFake userFake, HttpSession session,
			HashMap<String, User> map) {

		if (userFake.queryByUsernameAndPassword()) {
			User sessUser = (User) session.getAttribute("userSession");
			if (sessUser == null
					|| !sessUser.getId().equals(userFake.getUser().getId())) {
				sessUser = userFake.getUser();
				session.setAttribute("userSession", sessUser);
			}
			map.put("user", sessUser);
			return "user/userinfo";
		} else {
			session.invalidate();
			return "user/login";
		}
	}

}
