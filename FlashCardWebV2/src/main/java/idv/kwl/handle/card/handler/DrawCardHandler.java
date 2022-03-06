package idv.kwl.handle.card.handler;

import java.util.ArrayList;
import java.util.List;

import idv.kwl.dao.concrete.CardDao;
import idv.kwl.exception.FindErrorException;
import idv.kwl.model.Card;
import idv.kwl.tool.SpringUtil;

public class DrawCardHandler {
	private DrawCardCase cardCase;
	private List<Card> reviews = new ArrayList<>();
	private List<Card> passes = new ArrayList<>();

	public DrawCardHandler(DrawCardCase cardCase) {
		this.cardCase = cardCase;
	}

	public CardDao getCardDao() {
		return ((CardDao) SpringUtil.getBean("CardDao"));
	}

	public void addReview(Integer id) {
		try {
			Card card = this.cardCase.getCardByID(id);
			if (!(this.reviews.contains(card) || this.passes.contains(card))) {
				this.reviews.add(card);
				card.addUsageCount();
				getCardDao().update(card, id);
			}
		} catch (FindErrorException e) {
			System.out.println(this.getClass() + ":" + e.getMessage());
		}
	}

	public void addPass(Integer id) {
		try {
			Card card = this.cardCase.getCardByID(id);
			if (!(this.reviews.contains(card) || this.passes.contains(card))) {
				this.passes.add(card);
				card.addUsageCount();
				card.addPass_count();
				getCardDao().update(card, id);
			}
		} catch (FindErrorException e) {
			System.out.println(this.getClass() + ":" + e.getMessage());
		}
	}

	public Card drawNext() {

		if (!this.cardCase.hasNext()) {
			throw new FindErrorException("沒有資料");
		}

		return this.cardCase.draw();
	}

	public int count() {
		return this.cardCase.count();
	}

	public int current() {
		return this.cardCase.current();
	}

	public Card getLastCard() {
		return this.cardCase.getLastCard();
	}
}
