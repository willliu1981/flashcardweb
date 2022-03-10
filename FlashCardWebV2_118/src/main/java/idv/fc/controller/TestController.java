package idv.fc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import idv.fc.dao.abstraction.Dao;
import idv.fc.model.UserFake;
import idv.fc.model.Vocabulary;
import idv.fc.tool.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "query")
	public ModelAndView query() {

		UserFake uf = (UserFake) SpringUtil.getBean("UserFake");

		boolean r = uf.setUsername("admin").setPassword("1234")
				.queryByUsernameAndPassword();
		System.out.println(this.getClass() + ":" + uf.getUsername());
		return new ModelAndView("user/userinfo").addObject("user", uf.getUser());
	}

	@RequestMapping(value = "querySQL")
	public String querySQL() {
		Dao<Vocabulary> dao = (Dao<Vocabulary>) SpringUtil.getBean("VocabularyDao");
		List<Vocabulary> list = dao.querySQL(
				"select * from vocabulary where id=? and vocabulary=?", "v_by", "by");
		System.out.println(list.get(0).getTranslation());
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
