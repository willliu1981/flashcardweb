package idv.fc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.dao.abs.Dao;
import idv.fc.model.User;
import idv.fc.tool.SpringUtil;

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
	public String login(User user) {
		List<User> users = userCommonDao.querySQL(
				"select * from user where username=? and password=? ",
				user.getUsername(), user.getPassword());

		System.out.println(this.getClass() + ":" + users.isEmpty());

		return "test/test";
	}
}
