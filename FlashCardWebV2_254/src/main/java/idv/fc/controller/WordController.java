package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.pojo.Vocabulary;
import idv.fc.service.IVocabularyService;
import tool.SpringUtil;

@Controller
@RequestMapping(value = "word")
public class WordController {
	private static Logger logger = LoggerFactory
			.getLogger(WordController.class);

	@RequestMapping(value = "wordManager")
	public String toCardManager() {
		return "wordManager/managedPage";
	}

	@RequestMapping(value = "vocabulary")
	public String toWord(HashMap<String, List<Vocabulary>> map) {
		logger.info("");
		IVocabularyService service = SpringUtil.getBean("vocabularyService",
				IVocabularyService.class);
		map.put("vocabularys", service.getAllVocabulary());

		return "wordManager/vocabularyManagedPage";
	}

	@RequestMapping(value = "card")
	public String toCard() {

		return "wordManager/cardManagedPage";
	}

}
