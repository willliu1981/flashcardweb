package idv.kwl.handle.cardhandler.drawcardcase;

import java.util.List;

import idv.kwl.model.Card;

public class Rule1 implements DrawRule<Card> {

	@Override
	public List<Card> createList(List<Card> oriList) {

		return oriList;
	}

}
