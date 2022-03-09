package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.dao.abs.Dao;
import idv.fc.dao.proxy.UserDaoProxy;
import idv.fc.model.User;

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
	public String login(User queryUser, HttpSession session,
			HashMap<String, User> map) {
		UserDaoProxy proxy = new UserDaoProxy(queryUser, this.userCommonDao);

		if (proxy.queryByUsernameAndPassword()) {
			User sessUser = (User) session.getAttribute("userSession");
			if (sessUser == null || !sessUser.getId().equals(proxy.getUser().getId())) {
				sessUser = proxy.getUser();
				session.setAttribute("userSession", sessUser);
			}
			map.put("user", sessUser);
			return "user/userinfo";
		} else {
			session.invalidate();
			return "user/login";
		}
	}

//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String login(User user, HttpSession session, HashMap<String, User> map) {
//
//		List<User> users = userCommonDao.querySQL(
//				"select * from user where username=? and password=? ",
//				user.getUsername(), user.getPassword());
//
//		if (!users.isEmpty()) {
//			User sessUser = (User) session.getAttribute("userSession");
//			if (sessUser == null || !sessUser.getId().equals(users.get(0).getId())) {
//				sessUser = users.get(0);
//				session.setAttribute("userSession", sessUser);
//			}
//			map.put("user", sessUser);
//			return "user/userinfo";
//		} else {
//			session.invalidate();
//			return "user/login";
//		}
//	}
}
