package idv.kwl.handle.cardhandler.drawcardcase;

import java.util.List;

import idv.kwl.model.Card;

public interface DrawRule<T> {

	List<Card> createList(List<Card> oriList);
}
