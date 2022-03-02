package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.kwl.dao.concrete.CardDao;
import idv.kwl.model.Card;
import idv.kwl.tool.SpringUtil;

@Controller
@RequestMapping(value = "process/card")
public class CardMultiController {

	@RequestMapping(value = "add")
	public String add(Card card) {
		CardDao dao = (CardDao) SpringUtil.getBean("CardDao");

		card.setCreate_date(Date.valueOf(LocalDate.now()));

		dao.create(card);

		return "testresult";
	}

	@RequestMapping(value = "delete")
	public String delete(int cid) {
		CardDao dao = (CardDao) SpringUtil.getBean("CardDao");

		dao.delete(cid);

		return "testresult";
	}

	@RequestMapping(value = "update")
	public String update(Card card, int cid) {
		CardDao dao = (CardDao) SpringUtil.getBean("CardDao");

		dao.update(card, cid);

		return "testresult";
	}

	@RequestMapping(value = "query")
	public String queryAll(Model model) {
		CardDao dao = (CardDao) SpringUtil.getBean("CardDao");

		model.addAttribute("list", dao.queryAll());

		return "testlist";
	}

	@RequestMapping(value = "query/{cid}")
	public String queryByID(Model model, @PathVariable("cid") Integer cid) {
		CardDao dao = (CardDao) SpringUtil.getBean("CardDao");

		model.addAttribute("model", dao.queryById(cid));

		return "testlist";
	}

}
