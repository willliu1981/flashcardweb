package idv.kwl.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

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

	@RequestMapping(value = "spring/user", method = RequestMethod.PUT)
	public @ResponseBody String helloPUT(@RequestBody String userJson) {
		System.out.println(
				TestController.class + ":" + "PUT (before) =" + userJson.toString());
		Gson gson = new Gson();
		User user = gson.fromJson(userJson, User.class);
		User newUser = UserFactory.getUser(user.getUid());
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		UserFactory.update(user.getUid(), newUser);
		System.out.println(TestController.class + ":" + "PUT =" + newUser.toString());
		return gson.toJson(newUser);
	}

	@RequestMapping(value = "spring/user", method = RequestMethod.DELETE)
	public @ResponseBody String helloDelete(@RequestBody String id) {
		boolean res = UserFactory.delete(id);
		if (res) {
			System.out.println(TestController.class + ":" + id + " deleted");
			return "Delete success";
		}
		return "Delete error";
	}

}
