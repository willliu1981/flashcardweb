package idv.fc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.dao.abstraction.Dao;
import idv.fc.dao.factory.DaoFactory;
import idv.fc.interceptorhandler.UserHandler;
import idv.fc.model.User;
import idv.fc.model.Vocabulary;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.ProxyFactory.ProxyBuilder;
import idv.fc.proxy.interceptor.InterceptorImpl;
import idv.fc.tool.Debug;
import idv.fc.tool.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test")
	public String query(User user, HttpSession session) {

		User proxy = ProxyFactory.setInterceptor(new InterceptorImpl<User>())
				.setTarget(user).addInterceptHandler(new UserHandler())
				.getProxyInstance();
		proxy.setUsername("root");
		proxy.setPassword("1234");

		Debug.test(this, "user:====>" + proxy.getClass());

		return "user/userinfo";
	}

	@RequestMapping(value = "test2")
	public String querySQL(User user, HttpSession session) {

		User proxy = ProxyFactory.getProxyInstance("UserProxyFactory", user);
		proxy.setPassword("1234");

		Debug.test(this, proxy);
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
