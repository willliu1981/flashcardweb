package idv.kwl.handle.controller.concrete;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.fc.dao.CardDao;
import idv.fc.dao.VocabularyDao;
import idv.fc.model.Card;
import idv.fc.model.Vocabulary;
import idv.fc.model.proxy.CardProxy;
import idv.fc.model.proxy.ICard;
import idv.fc.tool.SpringUtil;
import idv.kwl.exception.FindErrorException;
import idv.kwl.handle.cardhandler.DrawCardHandler;
import idv.kwl.handle.cardhandler.HandleableCase;
import idv.kwl.handle.cardhandler.drawcardcase.DrawCardCase;

@Controller
@RequestMapping(value = "process/exam")
public class ExamMultiController {
	private static final String CARDDAO = "CardDao";
	private static final String VOCABULARYDAO = "VocabularyDao";
	private static final String HANDLEABLECASE = "handleableCase";
	private static final String DRAWCARDHANDLER = "drawCardHandler";
	private CardDao cardDao;

	private CardDao getCardDao() {
		if (cardDao == null) {
			cardDao = (CardDao) SpringUtil.getBean(CARDDAO);
		}
		return this.cardDao;
	}

	String userId = "u_admin";// test id

	public DrawCardHandler getDrawCardHandler(HttpSession session) {
		DrawCardHandler drawCardHandler = (DrawCardHandler) session
				.getAttribute("drawCardHandler");
		if ((drawCardHandler = (DrawCardHandler) session
				.getAttribute("drawCardHandler")) == null) {
			List<Card> cards = getCardDao().queryByUserId(userId);
			HandleableCase handleableCase = (HandleableCase) SpringUtil.getBean(HANDLEABLECASE);
			handleableCase.setCardList(cards);
			drawCardHandler = new DrawCardHandler(handleableCase);
			session.setAttribute(DRAWCARDHANDLER, drawCardHandler);
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
			vocabulary = ((VocabularyDao) SpringUtil.getBean(VOCABULARYDAO))
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

	@RequestMapping(value = "count/{number}")
	public String count(HttpSession session, @PathVariable("number") Integer number) {
		DrawCardHandler drawCardHandler = getDrawCardHandler(session);
		drawCardHandler.setDrawMax(number);
		return "exam/draw";
	}

}
