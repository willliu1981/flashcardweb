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

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String toLogin() {
		return "user/login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String toCreate() {
		return "user/create";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String toUpdate() {
		return "user/update";
	}

	/**
	 * create user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String create(UserFaker userFaker, HashMap<String, User> map) {
		userFaker.create();
		map.put("user", userFaker.getUser());
		return "user/login";
	}

	
	/**
	 * update user
	 * @param userFaker
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.PUT)
	public String update(UserFaker userFaker, HashMap<String, User> map) {
		userFaker.update(map);
		map.put("user", userFaker.getUser());
		return "user/login";
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
	 * 為隱藏id ,傳入引數使用 RedirectAttributes
	 * 接數參數 注解 ModelAttribute
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
