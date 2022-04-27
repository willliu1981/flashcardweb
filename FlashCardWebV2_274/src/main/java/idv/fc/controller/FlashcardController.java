package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.pojo.Vocabulary;
import idv.fc.service.IVocabularyService;
import tool.SpringUtil;

@Controller
@RequestMapping(value = "flashcard")
public class FlashcardController {
	private static Logger logger = LoggerFactory
			.getLogger(FlashcardController.class);

	@RequestMapping(value = "manager")
	public String toManager() {
		return "flashcard/managedPage";
	}

	@RequestMapping(value = "flashcardDetail")
	public String toFlashcardDetail(HashMap<String, List<Vocabulary>> map) {
		/*		IVocabularyService service = SpringUtil.getBean("vocabularyService",
						IVocabularyService.class);
				PageHelper.startPage(2, 5);
				List<Vocabulary> allVocabulary = service.getAllVocabulary();
				map.put("vocabularys", allVocabulary);
				PageInfo<Vocabulary> page = new PageInfo<>(allVocabulary, 5);
				logger.info("page:" + page);
		 */
		return "flashcard/flashcardDetailManagedPage";
	}

	@RequestMapping(value = "handledCardDetail")
	public String toHandledCardDetail() {
		return "flashcard/handledCardDetailManagedPage";
	}

}
