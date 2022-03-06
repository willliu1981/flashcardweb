package idv.kwl.handle.controller.concrete;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.kwl.dao.concrete.CardDao;
import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.exception.FindErrorException;
import idv.kwl.handle.card.handler.DrawCardCase;
import idv.kwl.handle.card.handler.DrawCardHandler;
import idv.kwl.model.Vocabulary;
import idv.kwl.model.proxy.CardProxy;
import idv.kwl.model.proxy.ICard;
import idv.kwl.tool.SpringUtil;

@Controller
@RequestMapping(value = "process/exam")
public class ExamMultiController {
	private CardDao cardDao;
	// @Autowired
	// @Qualifier("CardDao")
	// private CardDao dao;

	private CardDao getCardDao() {
		if (cardDao == null) {
			cardDao = (CardDao) SpringUtil.getBean("CardDao");
		}
		return this.cardDao;
	}

	String userId = "u_admin";// test id

	public DrawCardHandler getDrawCardHandler(HttpSession session) {
		DrawCardHandler drawCardHandler = (DrawCardHandler) session
				.getAttribute("drawCardHandler");
		if ((drawCardHandler = (DrawCardHandler) session
				.getAttribute("drawCardHandler")) == null) {
			drawCardHandler = new DrawCardHandler(
					new DrawCardCase(getCardDao().queryByUserId(userId)));
			session.setAttribute("drawCardHandler", drawCardHandler);
		}

		return drawCardHandler;
	}

	@RequestMapping(value = "draw")
	@ResponseBody
	public ICard draw(HttpSession session) {
		DrawCardHandler drawCardHandler = getDrawCardHandler(session);
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

	@RequestMapping(value = "move-right/{cid}")
	@ResponseBody
	public void flipRight(HttpSession session, @PathVariable("cid") Integer id) {
		DrawCardHandler drawCardHandler = getDrawCardHandler(session);
		drawCardHandler.addPass(id);
	}

	@RequestMapping(value = "move-left/{cid}")
	@ResponseBody
	public void flipLeft(HttpSession session, @PathVariable("cid") Integer id) {
		DrawCardHandler drawCardHandler = getDrawCardHandler(session);
		drawCardHandler.addReview(id);
	}

}
