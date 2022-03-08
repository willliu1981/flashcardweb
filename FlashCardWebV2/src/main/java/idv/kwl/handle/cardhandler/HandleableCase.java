package idv.kwl.handle.cardhandler;

import java.util.List;

import idv.kwl.exception.FindErrorException;
import idv.kwl.handle.cardhandler.drawcardcase.DrawRule;
import idv.kwl.model.Card;

public interface HandleableCase<T> {
	
	public void setCardList(List<T> cards) ;

	boolean hasNext();

	Card draw();

	int count();

	int current();

	Card getLastCard();

	Card getCardByID(Integer id) throws FindErrorException;

	void setDrawMax(int count);
	
	void setDrawRule(DrawRule<T> rule);

}