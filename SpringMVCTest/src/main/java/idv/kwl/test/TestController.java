package idv.kwl.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.kwl.test.model.User;

@Controller
public class TestController {

	@RequestMapping("hello")
	public String hello(User user) {

		System.out.println(TestController.class + ":" + "hello spring mvc");
		System.out.println(TestController.class + ":" + user.getUsername() + ":"
				+ user.getPassword());
		return "hellospringmvc";
	}

}
