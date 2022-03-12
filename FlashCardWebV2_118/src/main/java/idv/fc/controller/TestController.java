package idv.fc.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.User;
import idv.fc.model.Vocabulary;
import idv.fc.proxy.InterceptorAdapter;
import idv.fc.proxy.ProxyFactory;
import idv.fc.test.Faker;
import idv.fc.test.NewUserFaker;
import idv.fc.tool.Debug;
import idv.fc.tool.SpringUtil;
import net.sf.cglib.proxy.MethodProxy;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test")
	public String query(HttpSession session) {

		NewUserFaker faker = (NewUserFaker) SpringUtil.getBean("NewUserFaker");
		faker.setDisplay_name("Dennis");

		Debug.test(null, faker.getDisplay_name());
		Debug.test(null, faker.getUser().getDisplay_name());
		return "test/test";
	}

	@RequestMapping(value = "test2")
	public String querySQL() {
		User user = new User();
		User userProxy = (User) ProxyFactory
				.getProxyInstance(new InterceptorAdapter<User>() {

					@Override
					public Object intercept(Object obj, Method method, Object[] args,
							MethodProxy proxy) throws Throwable {

						Debug.test(null, proxy.getSignature().getName());

						return method.invoke(this.getTarget(), args);
					}

				}.setTarget(user));

		userProxy.setDisplay_name("aaa");
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
