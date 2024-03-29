package idv.fc.service.abstraction;

import com.github.pagehelper.Page;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.QuizDTO;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;

public interface IFlashcardService extends IService<Flashcard> {

	SimplePageInfoDTO getAllWithSimplePageInfoDTORequireCitedNumsArray(Page<Object> startPage,
			int maxNavPageNums);

	Flashcard getByTerm(String term);

	SimplePageInfoDTO getByTermUsingLikeCondition(Page<Object> startPage,
			int maxNavPageNums, String pattern);

	Integer getSearchPageNum(int pageSize, String pattern);

	SimplePageInfoDTO getAllWithSimplePageInfoDTO(Page<Object> startPage,
			int maxNavPageNums);

}
