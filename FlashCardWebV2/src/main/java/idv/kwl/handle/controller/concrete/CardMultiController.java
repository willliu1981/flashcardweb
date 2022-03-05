package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.kwl.dao.concrete.CardDao;
import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.exception.FindErrorException;
import idv.kwl.handle.card.handler.DrawCardCase;
import idv.kwl.handle.card.handler.DrawCardHandler;
import idv.kwl.model.Card;
import idv.kwl.model.Vocabulary;
import idv.kwl.model.proxy.CardProxy;
import idv.kwl.model.proxy.ICard;
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

	@RequestMapping(value = "draw")
	@ResponseBody
	public ICard draw(HttpSession session) {
		String userId = "u_admin";

		DrawCardHandler drawCardHandler = (DrawCardHandler) session
				.getAttribute("drawCardHandler");
		if ((drawCardHandler = (DrawCardHandler) session
				.getAttribute("drawCardHandler")) == null) {
			drawCardHandler = new DrawCardHandler(new DrawCardCase(
					((CardDao) SpringUtil.getBean("CardDao")).queryByUserId(userId)));
			session.setAttribute("drawCardHandler", drawCardHandler);
		}
		CardProxy cardProxy = null;
		Vocabulary vocabulary = null;
		try {
			cardProxy = new CardProxy(drawCardHandler.drawNext());
		} catch (FindErrorException e) {
			System.out.println(this.getClass() + ":" + e.getMessage());
			cardProxy = new CardProxy(drawCardHandler.getLastCard());
			cardProxy.setIsLast();
		} finally {
			vocabulary = ((VocabularyDao) SpringUtil.getBean("VocabularyDao"))
					.queryById(cardProxy.getVid());
			cardProxy.setVocabulary(vocabulary.getVocabulary());
			cardProxy.setTranslation(vocabulary.getTranslation());
		}
		System.out.println(this.getClass() + ":" + cardProxy);
		return cardProxy;
	}

}
