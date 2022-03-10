package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idv.fc.controller.abstraction.BaseController;
import idv.fc.model.User;
import idv.fc.model.UserFaker;

@Controller
//@RequestMapping(value = "user")
public class UserController extends BaseController {

	/**
	 * toXXX 表示轉發,以下類推
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String toLogin() {
		return "user/login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String toCreate() {
		return "user/create";
	}

	/**
	 * create user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String create(UserFaker userFaker) {
		System.out.println(this.getClass()+":"+userFaker.getUsername());
		userFaker.create();
		return "user/create";
	}

	/**
	 * query all
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String queryAll(HttpSession session, HashMap<String, List<User>> map) {
		List<User> users = this.getUserCommonDao().queryAll();
		map.put("users", users);
		System.out.println(this.getClass() + ":");
		users.forEach(System.out::println);
		return "user/usersinfo";
	}

	/**
	 * query by id
	 * @param userFaker
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String query(@ModelAttribute("id") String id, HttpSession session,
			HashMap<String, User> map) {
		User user = this.getUserCommonDao().queryById(id);
		map.put("user", user);
		return "user/userinfo";
	}

	/**
	 * check username and password
	 * @param userFaker
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserFaker userFaker, HttpSession session,
			RedirectAttributes rdAttr) {

		if (userFaker.queryByUsernameAndPassword()) {
			User sessUser = (User) session.getAttribute("userSession");
			if (sessUser == null
					|| !sessUser.getId().equals(userFaker.getUser().getId())) {
				sessUser = userFaker.getUser();
				session.setAttribute("userSession", sessUser);
			}
			rdAttr.addFlashAttribute("id", sessUser.getId());
			return "redirect:/user";
		} else {
			session.invalidate();
			return "user/login";
		}
	}

}
