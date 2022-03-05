package idv.kwl.handle.card.handler;

import idv.kwl.exception.FindErrorException;
import idv.kwl.model.Card;

public class DrawCardHandler {
	private DrawCardCase cardCase;

	public DrawCardHandler(DrawCardCase cardCase) {
		this.cardCase = cardCase;
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
