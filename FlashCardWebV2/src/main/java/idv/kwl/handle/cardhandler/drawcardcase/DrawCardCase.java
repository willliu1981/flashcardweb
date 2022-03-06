package idv.kwl.handle.cardhandler.drawcardcase;

import java.util.ArrayList;
import java.util.List;

import idv.kwl.exception.FindErrorException;
import idv.kwl.handle.cardhandler.HandleCase;
import idv.kwl.model.Card;

public class DrawCardCase implements HandleCase<Card> {
	private List<Card> cards = new ArrayList<>();
	private DrawRule<Card> rule;

	private int pointer = 0;// 1 ~ cards.size

	public DrawCardCase() {
	}

	public DrawCardCase(List<Card> cards) {
		this.cards = cards;
	}

	public void setCardList(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public boolean hasNext() {
		return this.pointer < cards.size();
	}

	@Override
	public Card draw() {
		// draw next
		return cards.get(++pointer - 1);
	}

	@Override
	public int count() {
		return this.cards.size();
	}

	@Override
	public int current() {
		return this.pointer;
	}

	@Override
	public Card getLastCard() {
		return this.cards.get(cards.size() - 1);
	}

	@Override
	public Card getCardByID(Integer id) throws FindErrorException {
		return this.cards.stream().filter(x -> x.getCid().equals(id)).findFirst()
				.orElseThrow(() -> new FindErrorException(this.getClass() + ":" + id));
	}

	@Override
	public void setDrawMax(int count) {
		this.setCardList(rule.createList(this.cards));
	}

	@Override
	public void setDrawRule(DrawRule<Card> rule) {
		this.rule = rule;

	}

}
