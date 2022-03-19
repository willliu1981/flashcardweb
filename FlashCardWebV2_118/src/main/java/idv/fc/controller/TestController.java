package idv.fc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idv.fc.concretion.proxy.UserFaker;
import idv.fc.dao.abstraction.Dao;
import idv.fc.exception.FindErrorException;
import idv.fc.model.User;
import idv.fc.model.Vocabulary;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.interceptor.Shuttle;
import idv.fc.tool.Debug;
import idv.fc.tool.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test")
	public String query(UserFaker proxy, HttpSession session) {

		User user = new User();
		Shuttle shuttle = new Shuttle();
		try {
			ProxyFactory<User> factory = SpringUtil.getBean("UserProxyFactory2",
					ProxyFactory.class);
			User userProxy = factory.getProxyInstance(user, shuttle);

//			User userProxy = ProxyFactory.getProxyInstance("UserProxyFactory2", user,
//					shuttle);
			shuttle.put("token", "tk123456");

			userProxy.setAuth("admin");
			Debug.test(this, userProxy);

		} catch (FindErrorException e) {
			e.printStackTrace();
		}

		return "test/test";
	}

	@RequestMapping(value = "test3")
	public String test3(User user, HttpSession session, RedirectAttributes rdAttr,
			HttpServletRequest req, HttpServletResponse resp,
			HashMap<String, User> map) {

		User sessuser = (User) session.getAttribute("userSession");
		map.put("user", sessuser);

		return "user/userinfo";
	}

	@RequestMapping(value = "test4")
	public String test4(UserFaker user, String token, Vocabulary vocabulary,
			HttpSession session, RedirectAttributes rdAttr) {

		// session.setAttribute("token", token);

		Debug.test(this, "1..." + user.getAuth());
		Debug.test(this, "2..." + user.getId());
		// Debug.test(this, "3..." + vocabulary.getId());

		// Debug.test(this, "4..." + user.getAuth());
		// user.setAuth("admin");

		return "test/test";
	}

	@RequestMapping(value = "test2")
	public String querySQL(User user, HttpSession session, RedirectAttributes rdAttr) {
		Debug.test(this, "test2..." + user.getUsername());

		session.setAttribute("token", "admin");
		rdAttr.addAttribute("auth", user.getAuth());
		rdAttr.addAttribute("username", user.getUsername());
		rdAttr.addAttribute("password", user.getPassword());

		return "redirect:/test/test";
	}

	@RequestMapping(value = "testsession")
	public String testSession(User user, HttpSession session) {

		return "test/test";
	}

	@RequestMapping(value = "add")
	public String add() {
		Dao<Vocabulary> dao = SpringUtil.getBean("VocabularyDao", Dao.class);
		Vocabulary v = new Vocabulary();
		v.setId("v_find");
		v.setVocabulary("find");
		v.setTranslation("查找");
		try {
			dao.create(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/test";
	}

	@RequestMapping(value = "update")
	public String update() {
		Dao<Vocabulary> dao = SpringUtil.getBean("VocabularyDao", Dao.class);
		Vocabulary v = new Vocabulary();
		v.setId("v_such");
		v.setVocabulary("such");
		v.setTranslation("這種");
		try {
			dao.update(v, "xxx");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/test";
	}
}
