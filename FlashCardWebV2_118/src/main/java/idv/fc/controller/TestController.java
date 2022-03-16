package idv.fc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idv.fc.concretion.proxy.UserFaker;
import idv.fc.dao.abstraction.Dao;
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
		Debug.test(this, "test...");

		Debug.test(this, "before username:" + proxy.getUsername());
		Debug.test(this, "before password:" + proxy.getPassword());
		Debug.test(this, "before auth:" + proxy.getAuth());
		proxy.setUsername("helen");
		proxy.setPassword("666");
		proxy.setAuth("admin");
		Debug.test(this, "after username:" + proxy.getUsername());
		Debug.test(this, "agter password:" + proxy.getPassword());
		Debug.test(this, "after auth:" + proxy.getAuth());

		return "test/test";
	}

	@RequestMapping(value = "test3")
	public String test3(User user, HttpSession session, RedirectAttributes rdAttr,
			HttpServletRequest req, HttpServletResponse resp) {
		// Debug.test(this, "test3..." + userFaker.getUsername());

		Vocabulary v = new Vocabulary();

		rdAttr.addAttribute("auth", "common");
		rdAttr.addAttribute("id", 1111);

		// session.setAttribute("token", "admin");

		rdAttr.addAttribute("token", "admin");

		return "redirect:/test/test4";
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
		dao.create(v);
		return "test/test";
	}

	@RequestMapping(value = "update")
	public String update() {
		Dao<Vocabulary> dao = SpringUtil.getBean("VocabularyDao", Dao.class);
		Vocabulary v = new Vocabulary();
		v.setId("v_such");
		v.setVocabulary("such");
		v.setTranslation("這種");
		dao.update(v, "xxx");
		return "test/test";
	}
}
