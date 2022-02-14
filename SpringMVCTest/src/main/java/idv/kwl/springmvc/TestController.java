package idv.kwl.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "spring/user", method = RequestMethod.PUT, params = {
			"name", "password" })
	// @ResponseBody
	public void helloPUT(User user) {
		System.out.println(
				TestController.class + ":" + "PUT (before) =" + user.toString());
		User u = UserFactory.getUser(user.getUid());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		UserFactory.Update(user.getUid(), u);
		System.out.println(TestController.class + ":" + "PUT =" + u.toString());
		// return "PUT success";
	}

	@ResponseBody
	public String helloDelete(User user) {
		System.out.println(
				TestController.class + ":" + "PUT (before) =" + user.toString());
		User u = UserFactory.getUser(user.getUid());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		UserFactory.Update(user.getUid(), u);
		System.out.println(TestController.class + ":" + "PUT =" + u.toString());
		return "PUT success";
	}

}
