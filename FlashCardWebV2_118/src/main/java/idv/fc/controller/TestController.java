package idv.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.dao.VocabularyDao;
import idv.fc.tool.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "jdbc")
	public String test() {
		VocabularyDao dao = (VocabularyDao) SpringUtil.getBean("VocabularyDao");
		System.out.println(dao.queryById("v_all").getTranslation());
		return "test/test";
	}
}
