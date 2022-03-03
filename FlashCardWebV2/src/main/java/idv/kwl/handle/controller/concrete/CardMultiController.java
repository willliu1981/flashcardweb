package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.kwl.dao.concrete.CardDao;
import idv.kwl.model.Card;
import idv.kwl.tool.SpringUtil;

@Controller
@RequestMapping(value = "process/card")
public class CardMultiController {
	// private CardDao dao = (CardDao) SpringUtil.getBean("CardDao");
	// @Autowired
	// private CardDao dao;
	private CardDao dao = (CardDao) new ClassPathXmlApplicationContext()
			.getBean("CardDao");

	@RequestMapping(value = "add")
	public String add(Card card) {
		//CardDao dao = (CardDao) SpringUtil.getBean("CardDao");
		card.setCreate_date(Date.valueOf(LocalDate.now()));
		dao.create(card);

		return "testresult";
	}

	/*
	@RequestMapping(value = "delete")
	public String delete(int cid) {
		dao.delete(cid);
	
		return "testresult";
	}
	
	@RequestMapping(value = "update")
	public String update(Card card, int cid) {
		dao.update(card, cid);
	
		return "testresult";
	}
	
	@RequestMapping(value = "query")
	public String queryAll(Model model) {
		model.addAttribute("list", dao.queryAll());
	
		return "testlist";
	}
	
	@RequestMapping(value = "query/{cid}")
	public String queryByID(Model model, @PathVariable("cid") Integer cid) {
		model.addAttribute("model", dao.queryById(cid));
	
		return "testlist";
	}
	//*/
}
