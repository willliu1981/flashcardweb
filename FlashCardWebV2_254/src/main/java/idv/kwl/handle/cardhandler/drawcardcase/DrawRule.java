package idv.kwl.handle.cardhandler.drawcardcase;

import java.util.List;

import idv.fc.model.Card;

public interface DrawRule<T> {

	List<Card> createList(List<Card> oriList);

}
