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

	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String toLogin(User user) {
		return "user/login";
	}

	@RequestMapping(value = "toQuery", method = RequestMethod.GET)
	public String toQuery() {
		List<User> users = userCommonDao.queryAll();
		users.forEach(System.out::println);

		return "test/test";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(User user) {

		System.out.println(this.getClass() + ":");

		return "test/test";
	}
}
