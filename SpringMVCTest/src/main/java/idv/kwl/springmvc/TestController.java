package idv.kwl.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;

@Controller
@RequestMapping(path = "spring")
public class TestController {
	@RequestMapping(path = "hello")
	public @ResponseBody String getAll() {

		return "spring get all : " + UserFactory.getAll();
	}

	@RequestMapping(path = "hello/{un}/{pw}")
	public @ResponseBody String helloTest(@PathVariable("un") String username,
			@PathVariable("pw") String password) {
		User u = UserFactory.login(username, password);
		System.out.println(TestController.class);
		System.out.println("user :" + u.toString());
		return "hellospringmvc: " + u.toString();
	}

	@RequestMapping(path = "hello/{key}")
	public @ResponseBody String springPost(@PathVariable("key") String key,
			String username, String password) {
		System.out.println("key :" + key);
		User u = new User();
		u.setUid(key);
		u.setUsername(username);
		u.setPassword(password);

		boolean res = UserFactory.add(u);
		System.out.println("user :" + u.toString());
		return "spring add: " + u.toString() + " res=" + res;
	}

	@RequestMapping(value = "user", method = RequestMethod.PUT)
	public @ResponseBody String helloPUT(@RequestBody String userJson) {
		System.out.println(
				TestController.class + ":" + "PUT (before) =" + userJson.toString());
		Gson gson = new Gson();
		User user = gson.fromJson(userJson, User.class);
		User newUser = UserFactory.getUserByID(user.getUid());
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		UserFactory.update(user.getUid(), newUser);
		System.out.println(TestController.class + ":" + "PUT =" + newUser.toString());
		return gson.toJson(newUser);
	}

	@RequestMapping(value = "user", method = RequestMethod.DELETE)
	public @ResponseBody String helloDelete(@RequestBody String id) {
		boolean res = UserFactory.delete(id);
		if (res) {
			System.out.println(TestController.class + ":" + id + " deleted");
			return "Delete success";
		}
		return "Delete error";
	}

}
