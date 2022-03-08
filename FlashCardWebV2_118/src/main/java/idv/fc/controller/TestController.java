package idv.fc.controller;

import java.sql.Date;
import java.time.LocalDate;

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
		System.out.println(dao.queryAll());
		return "test/test";
	}

	@RequestMapping(value = "add")
	public String add() {
		System.out.println(this.getClass() + ":xxx");
		Dao<Vocabulary> dao = (Dao<Vocabulary>) SpringUtil.getBean("VocabularyDao");
		Vocabulary v = new Vocabulary();
		v.setId("xxx");
		v.setVocabulary("xx1");
		v.setTranslation("yy2");
		dao.create(v);
		return "test/test";
	}
}