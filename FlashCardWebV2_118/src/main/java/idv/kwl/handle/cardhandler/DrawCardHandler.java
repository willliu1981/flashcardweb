package idv.kwl.handle.cardhandler;

import java.util.ArrayList;
import java.util.List;

import idv.fc.dao.concrete.CardDao;
import idv.fc.tool.SpringUtil;
import idv.kwl.exception.FindErrorException;
import idv.kwl.handle.cardhandler.drawcardcase.DrawRule;
import idv.kwl.model.Card;

public class DrawCardHandler implements HandleableCase<Card> {
	private HandleableCase<Card> cardCase;
	private List<Card> reviews = new ArrayList<>();
	private List<Card> passes = new ArrayList<>();

	public DrawCardHandler(HandleableCase<Card> cardCase) {
		this.cardCase = cardCase;
	}

	public CardDao getCardDao() {
		return ((CardDao) SpringUtil.getBean("CardDao"));
	}

	public void addReview(Integer id) {
		try {
			Card card = this.getCardByID(id);
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

		if (!this.hasNext()) {
			throw new FindErrorException("沒有資料");
		}

		return this.draw();
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

	public void setDrawMax(int count) {
		this.cardCase.setDrawMax(count);
	}

	@Override
	public Card draw() {
		return this.cardCase.draw();
	}

	@Override
	public Card getCardByID(Integer id) throws FindErrorException {
		return this.cardCase.getCardByID(id);
	}

	@Override
	public boolean hasNext() {
		return this.cardCase.hasNext();
	}

	@Override
	public void setCardList(List<Card> cards) {
		throw new UnsupportedOperationException(this.getClass()+":不支持 set card list");
	}

	@Override
	public void setDrawRule(DrawRule<Card> rule) {
		throw new UnsupportedOperationException(this.getClass()+":不支持 set card list");
	}
}
