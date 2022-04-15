package idv.kwl.handle.cardhandler.drawcardcase;

import java.util.List;
import java.util.stream.Collectors;

import idv.fc.model.Card;

public class Rule1 implements DrawRule<Card> {

	@Override
	public List<Card> createList(List<Card> oriList) {

		return oriList.stream().filter(x -> x.getUsage_count() <= 5)
				.collect(Collectors.toList());
	}

}
