package idv.fc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.Flashcard;
import idv.fc.service.IFlashcardService;
import tool.SpringUtil;

@Controller
@RequestMapping(value = "flashcard")
public class FlashcardController {
	private static final Integer MAX_PAGE_NUMBER = 5;
	private static final Integer MAX_NAV_PAGE_NUMBER = 5;

	private static Logger logger = LoggerFactory
			.getLogger(FlashcardController.class);

	@RequestMapping(value = "manager")
	public String toManager() {
		return "flashcard/managedPage";
	}

	@RequestMapping(value = "flashcardDetail")
	public String toFlashcardDetail(HashMap<String, Object> map,
			@RequestParam(value = "pageNumber", required = false) String pageNumber) {

		IFlashcardService service = SpringUtil.getBean("flashcardService",
				IFlashcardService.class);
		int intPageNumber = 1;
		if (pageNumber != null && !pageNumber.equals("")) {
			intPageNumber = Integer.valueOf(pageNumber);
		}

		Page<Object> startPage = PageHelper.startPage(intPageNumber,
				MAX_PAGE_NUMBER);
		List<Flashcard> all = service.getAll();
		map.put("flashcards", all);
		PageInfo<Flashcard> pageInfo = new PageInfo<>(all, MAX_NAV_PAGE_NUMBER);
		map.put("pageInfo", pageInfo);

		//*
		pageInfo.getStartRow();
		pageInfo.getNavigateFirstPage();
		pageInfo.getNavigateLastPage();

		int length = pageInfo.getNavigatepageNums().length;
		logger.info("startPage:" + startPage);
		logger.info("pageInfo:" + pageInfo);
		Arrays.stream(pageInfo.getNavigatepageNums()).boxed()
				.collect(Collectors.toList())
				.forEach(x -> logger.info("x=" + x));
		//*/

		return "flashcard/flashcardDetailManagedPage";
	}

	@RequestMapping(value = "handledCardDetail")
	public String toHandledCardDetail() {
		return "flashcard/handledCardDetailManagedPage";
	}

}
