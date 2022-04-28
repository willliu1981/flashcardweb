package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.Flashcard;
import idv.fc.pojo.Vocabulary;
import idv.fc.service.IFlashcardService;
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
	public String toFlashcardDetail(HashMap<String, List<Flashcard>> map) {
		//*
		IFlashcardService service = SpringUtil.getBean("flashcardService",
				IFlashcardService.class);
		PageHelper.startPage(1, 5);
		List<Flashcard> all = service.getAll();
		map.put("flashcards", all);
		PageInfo<Flashcard> page = new PageInfo<>(all, 5);
		logger.info("page:" + map.size());
		//*/
		return "flashcard/flashcardDetailManagedPage";
	}

	@RequestMapping(value = "handledCardDetail")
	public String toHandledCardDetail() {
		return "flashcard/handledCardDetailManagedPage";
	}

}
