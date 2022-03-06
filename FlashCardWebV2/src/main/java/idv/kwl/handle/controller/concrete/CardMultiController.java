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
	private CardDao dao;
	// @Autowired
	// @Qualifier("CardDao")
	// private CardDao dao;

	private CardDao getDao() {
		if (dao == null) {
			dao = (CardDao) SpringUtil.getBean("CardDao");
		}
		return this.dao;
	}

	@RequestMapping(value = "add")
	public String add(Card card) {
		card.setCreate_date(Date.valueOf(LocalDate.now()));
		getDao().create(card);

		return "testresult";
	}

	@RequestMapping(value = "delete/{cid}")
	public String delete(@PathVariable("cid") int cid) {
		getDao().delete(cid);

		return "testresult";
	}

	@RequestMapping(value = "update")
	public String update(Card card) {
		getDao().update(card, card.getCid());

		return "testresult";
	}

	@RequestMapping(value = "query")
	public String queryAll(Model model) {
		model.addAttribute("list", getDao().queryAll());

		return "testlist";
	}

	@RequestMapping(value = "query/{cid}")
	public String queryByID(Model model, @PathVariable("cid") Integer cid) {
		model.addAttribute("model", getDao().queryById(cid));

		return "testlist";
	}

}
