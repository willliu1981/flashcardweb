package idv.fc.mybatis.mapper;

import idv.fc.pojo.Card;

public interface CardMapper {

	int insertCard(Card card);

	Card queryById(int id);

	Card queryByIdByStepOne(int id);

	default Card queryByIdByStep(int id) {
		return queryByIdByStepOne(id);
	}

}
