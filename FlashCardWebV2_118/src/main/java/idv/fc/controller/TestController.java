package idv.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.dao.abs.Dao;
import idv.fc.model.Vocabulary;
import idv.fc.tool.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "query")
	public String query() {
		Dao<Vocabulary> dao = (Dao<Vocabulary>) SpringUtil.getBean("VocabularyDao");
		System.out.println(dao.queryById("v_as").getTranslation());
		return "test/test";
	}

	@RequestMapping(value = "add")
	public String add() {
		Dao<Vocabulary> dao = (Dao<Vocabulary>) SpringUtil.getBean("VocabularyDao");
		Vocabulary v = new Vocabulary();
		v.setId("v_give");
		v.setVocabulary("give");
		v.setTranslation("授予");
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
