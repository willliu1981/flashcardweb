package idv.kwl.handle.card.handler;

import java.util.ArrayList;
import java.util.List;

import idv.kwl.exception.FindErrorException;
import idv.kwl.model.Card;

public class DrawCardCase {
	private List<Card> cards = new ArrayList<>();

	private int pointer = 0;// 1 ~ cards.size

	public DrawCardCase(List<Card> cards) {
		this.cards = cards;
	}

	public boolean hasNext() {
		return this.pointer < cards.size();
	}

	public Card draw() {
		// draw next
		return cards.get(++pointer - 1);
	}

	public int count() {
		return this.cards.size();
	}

	public int current() {
		return this.pointer;
	}

	public Card getLastCard() {
		return this.cards.get(cards.size() - 1);
	}

	public Card getCardByID(Integer id) throws FindErrorException {
		return this.cards.stream().filter(x -> x.getCid().equals(id)).findFirst()
				.orElseThrow(() -> new FindErrorException(this.getClass() + ":" + id));

	}

}
