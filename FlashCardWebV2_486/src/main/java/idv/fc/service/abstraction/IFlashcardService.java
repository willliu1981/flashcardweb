package idv.fc.service.abstraction;

import java.util.List;

import com.github.pagehelper.Page;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.QuizDTO;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;

public interface IFlashcardService extends IService<Flashcard> {

	SimplePageInfoDTO getAllWithSimplePageInfoDTO(Page<Object> startPage, int maxNavPageNums);

	Flashcard getByTerm(String term);


}
