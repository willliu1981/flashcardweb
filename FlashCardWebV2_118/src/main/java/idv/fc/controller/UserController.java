package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;
import idv.fc.model.UserFake;

@Controller
//@RequestMapping(value = "user")
public class UserController {
	@Autowired
	@Qualifier("UserCommonDao")
	private Dao<User> userCommonDao;

	/**
	 * toXXX 表示轉發,以下類推
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String toLogin(User user) {
		return "user/login";
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String queryAll(HttpSession session, HashMap<String, List<User>> map) {
		List<User> users = userCommonDao.queryAll();
		map.put("users", users);
		return "user/usersinfo";
	}

	/**
	 * query by id
	 * @param userFake
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String query(@ModelAttribute("id") String id, HttpSession session,
			HashMap<String, User> map) {
		User user = this.userCommonDao.queryById(id);
		map.put("user", user);
		return "user/userinfo";
	}

	/**
	 * check username and password
	 * @param userFake
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserFake userFake, HttpSession session,
			HashMap<String, String> map, RedirectAttributes rdAttr) {

		if (userFake.queryByUsernameAndPassword()) {
			User sessUser = (User) session.getAttribute("userSession");
			if (sessUser == null
					|| !sessUser.getId().equals(userFake.getUser().getId())) {
				sessUser = userFake.getUser();
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
