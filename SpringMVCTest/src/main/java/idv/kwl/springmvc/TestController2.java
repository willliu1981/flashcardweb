package idv.kwl.springmvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;

@Controller
@RequestMapping(path = "spring2")
public class TestController2 {
	@RequestMapping(path = "test1{key2}")
	public @ResponseBody String getAll(@PathVariable("key") String key,
			@PathVariable("key2") String key2) {
		List list = UserFactory.getAll();
		System.out.println("spring2 " + key);
		System.out.println("spring2 " + key2);
		System.out.println("spring2 " + list);
		return "spring 2 : " + list;
	}

	@RequestMapping(path = "test2/{key}")
	public @ResponseBody String getAll2(@PathVariable("key") String key) {
		List list = UserFactory.getAll();
		System.out.println("spring2 " + "test2");
		System.out.println("spring2 " + key);
		System.out.println("spring2 " + list);
		return "spring 2 test2 : " + list;
	}

	@RequestMapping(path = "test3")
	public @ResponseBody String getAll3(@RequestParam("name") String username,
			String name) {
		List list = UserFactory.getAll();
		System.out.println("spring2 " + "test3");
		System.out.println("spring2 " + username);
		System.out.println("spring2 " + name);
		System.out.println("spring2 " + list);
		return "spring 2 test2 : " + list;
	}

	@RequestMapping(path = "test4")
	public @ResponseBody String createUser(User user) {
		boolean res = UserFactory.add(user);
		System.out.println("spring2 " + "test4");
		System.out.println("spring2 " + user);
		return "success";
	}

}
