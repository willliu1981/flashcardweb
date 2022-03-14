package idv.fc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.dao.abstraction.Dao;
import idv.fc.dao.factory.DaoFactory;
import idv.fc.model.User;
import idv.fc.model.Vocabulary;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.interceptor.InterceptorImpl;
import idv.fc.proxy.interceptor.concretion.UserHandler;
import idv.fc.tool.Debug;
import idv.fc.tool.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test")
	public String query(User user, HttpSession session) {

		User proxy = (User) ProxyFactory
				.createWithInterceptor(new InterceptorImpl<User>(new UserHandler()))
				.setTarget(user).getProxyInstance();
		proxy.setUsername("root");
		proxy.setPassword("1234");
		Debug.test(this, proxy.getUsername());

		return "user/userinfo";
	}

	@RequestMapping(value = "test2")
	public String querySQL() {

		User user = DaoFactory.getUserDao().queryById("u_apple666");

		Debug.test(this, user.getUsername());
		return "test/test";
	}

	@RequestMapping(value = "add")
	public String add() {
		Dao<Vocabulary> dao = (Dao<Vocabulary>) SpringUtil.getBean("VocabularyDao");
		Vocabulary v = new Vocabulary();
		v.setId("v_find");
		v.setVocabulary("find");
		v.setTranslation("查找");
		dao.create(v);
		return "test/test";
	}

	@RequestMapping(value = "update")
	public String update() {
		Dao<Vocabulary> dao = (Dao<Vocabulary>) SpringUtil.getBean("VocabularyDao");
		Vocabulary v = new Vocabulary();
		v.setId("v_such");
		v.setVocabulary("such");
		v.setTranslation("這種");
		dao.update(v, "xxx");
		return "test/test";
	}
}
