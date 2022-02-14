package idv.kwl.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;

@Controller
public class TestController {

	@RequestMapping(path = "spring/hello")
	public String helloTest(String username, String password) {
		User u = UserFactory.getUser("u_1001");
		System.out.println(TestController.class);
		System.out.println("user :" + u.toString());
		return "hellospringmvc";
	}

//	@RequestMapping(value = "hello")
//	public String helloPOST(User user) {
//		System.out.println(TestController.class + ":" + "hello spring mvc POST");
//		System.out.println(TestController.class + ":" + user.getUsername() + ":"
//				+ user.getPassword());
//		return "hellospringmvc";
//	}
//
//	@RequestMapping(value = "hello", method = RequestMethod.GET)
//	public String helloGET1(User user) {
//
//		System.out.println(TestController.class + ":" + "hello spring mvc GET ");
//		System.out.println(TestController.class + ":" + user.getUsername() + ":"
//				+ user.getPassword());
//		return "hellospringmvc";
//	}

//	@RequestMapping(value = "hello", method = RequestMethod.GET, params = { "username",
//			"password" })
//	public String helloGET2(User user) {
//
//		System.out.println(
//				TestController.class + ":" + "hello spring mvc GET require params");
//		System.out.println(TestController.class + ":" + user.getUsername() + ":"
//				+ user.getPassword());
//		return "hellospringmvc";
//	}

}
