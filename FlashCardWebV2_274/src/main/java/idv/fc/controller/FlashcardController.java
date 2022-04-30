package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.Flashcard;
import idv.fc.service.IFlashcardService;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "flashcards")
public class FlashcardController {
	private static final Integer MAX_PAGE_NUMBER = 5;
	private static final Integer MAX_NAV_PAGE_NUMBER = 5;
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base path

	protected static Logger logger = LoggerFactory
			.getLogger(FlashcardController.class);

	@Autowired
	IFlashcardService flashcardService;

	/*
	 * 管理 Flashcard & FlashcardHolder
	 */
	@RequestMapping(value = "fcsManager")
	public String toFlashcardsManager() {
		return FLASHCARDS + "/fcsManagedPage";
	}

	@RequestMapping(value = "fcManager")
	public String toFlashcardManagerForDefaultPageNumber(
			HashMap<String, Object> map) {
		return toFlashcardManagerWithPageNumber(map, null);
	}

	@RequestMapping(value = "fcManager/{pageNumber}")
	public String toFlashcardManagerWithPageNumber(HashMap<String, Object> map,
			@PathVariable(value = "pageNumber") String pageNumber) {
		int intPageNumber = 1;//default pageNumber
		if (pageNumber != null && !pageNumber.equals("")) {
			intPageNumber = Integer.valueOf(pageNumber);
		}

		PageHelper.startPage(intPageNumber, MAX_PAGE_NUMBER);
		List<Flashcard> all = flashcardService.getAll();
		map.put("flashcards", all);
		PageInfo<Flashcard> pageInfo = new PageInfo<>(all, MAX_NAV_PAGE_NUMBER);
		map.put("pageInfo", pageInfo);

		return FLASHCARDS + "/fcManagedPage";
	}

	@RequestMapping(value = "fhManager")
	public String toFlashcardHolderManager() {
		return FLASHCARDS + "/fhManagedPage";
	}

}
