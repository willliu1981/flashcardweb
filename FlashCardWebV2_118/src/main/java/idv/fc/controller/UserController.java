package idv.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.model.User;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String toLogin(User user) {
		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(User user) {
		System.out.println(this.getClass()+":");
		return "test/test";
	}
}
