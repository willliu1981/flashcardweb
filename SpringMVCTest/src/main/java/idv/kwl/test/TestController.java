package idv.kwl.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.kwl.test.model.User;

@Controller
public class TestController {

	@RequestMapping(value = "hello")
	public String helloPOST(User user) {

		System.out.println(TestController.class + ":" + "hello spring mvc POST");
		System.out.println(TestController.class + ":" + user.getUsername() + ":"
				+ user.getPassword());
		return "hellospringmvc";
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET, params = "password")
	public String helloGET1(User user) {

		System.out.println(TestController.class + ":" + "hello spring mvc GET ");
		System.out.println(TestController.class + ":" + user.getUsername() + ":"
				+ user.getPassword());
		return "hellospringmvc";
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET, params = { "username",
			"password" })
	public String helloGET2(User user) {

		System.out.println(
				TestController.class + ":" + "hello spring mvc GET require params");
		System.out.println(TestController.class + ":" + user.getUsername() + ":"
				+ user.getPassword());
		return "hellospringmvc";
	}

}
