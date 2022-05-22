package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.taglib.impl.list.flashcardholder.FlashcardHolderDTOListFacade;
import idv.taglib.factory.lister.ListFacade;

@Controller
@RequestMapping(value = "flashcards")
public class FlashcardsController extends BaseController {
	private static final Integer MAX_PAGE_NUMBER = 5;
	private static final Integer MAX_NAV_PAGE_NUMBER = 5;
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base path

	@Autowired
	IFlashcardService flashcardService;

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@Autowired
	IHolderDataService holderDataService;

	/*
	 * 管理 Flashcard & FlashcardHolder
	 */

	@RequestMapping(value = "fcsManager")
	public String toFlashcardsManager() {
		return FLASHCARDS + "/fcsManagedPage.jsp";
	}

	// manage flashcard begin
	@RequestMapping(value = "fcManager")
	public String toFlashcardManager() {
		return FLASHCARDS + "/modelManager/flashcardManagedPage.html";
	}

	// manage flashcard begin
	/*@RequestMapping(value = "fcManagerOld")
	public String toFlashcardManagerOld(HashMap<String, Object> map,
			HttpServletRequest request) {
		return toFlashcardManagerWithPageNumberOld(map, null, request);
	}
	
	@RequestMapping(value = "fcManagerOld/{pageNumber}")
	public String toFlashcardManagerWithPageNumberOld(
			HashMap<String, Object> map,
			@PathVariable(value = "pageNumber") String pageNumber,
			HttpServletRequest request) {
		int intPageNumber = 1;//default pageNumber
		if (pageNumber != null && !pageNumber.equals("")) {
			intPageNumber = Integer.valueOf(pageNumber);
		}
	
		PageHelper.startPage(intPageNumber, MAX_PAGE_NUMBER);
		List<Flashcard> all = flashcardService.getAll();
		PageInfo<Flashcard> pageInfo = new PageInfo<>(all, MAX_NAV_PAGE_NUMBER);
	
		map.put("pageInfo", pageInfo);
		map.put("datas", all);
		map.put("type", ListFacade.FLASHCARD);
	
		return FLASHCARDS + "/modelManagedPage";
	}*/
	//manage flashcard end

	//manage flashcardHolder begin
	@RequestMapping(value = "fhManager")
	public String toFlashcardHolderManager(HashMap<String, Object> map) {
		return toFlashcardHolderManagerWithPageNumber(map, null);
	}

	@RequestMapping(value = "fhManager/{pageNumber}")
	public String toFlashcardHolderManagerWithPageNumber(
			HashMap<String, Object> map,
			@PathVariable(value = "pageNumber") String pageNumber) {
		int intPageNumber = 1;//default pageNumber
		if (pageNumber != null && !pageNumber.equals("")) {
			intPageNumber = Integer.valueOf(pageNumber);
		}

		PageHelper.startPage(intPageNumber, MAX_PAGE_NUMBER);
		//List<FlashcardHolder> all = flashcardHolderService.getAll();
		List<FlashcardHolderDTO> all = flashcardHolderService.getAllJoinFc();

		map.put("flashcardHolders", all);
		PageInfo<FlashcardHolderDTO> pageInfo = new PageInfo<>(all,
				MAX_NAV_PAGE_NUMBER);

		map.put("pageInfo", pageInfo);
		map.put("datas", all);
		map.put("type", FlashcardHolderDTOListFacade.class);

		return FLASHCARDS + "/modelManagedPage";
	}
	//manage flashcardHolder end

	//manage holderData begin
	@RequestMapping(value = "hdManager")
	public String toHolderDataManager(HashMap<String, Object> map) {
		return toHolderDataManagerWithPageNumber(map, null);
	}

	@RequestMapping(value = "hdManager/{pageNumber}")
	public String toHolderDataManagerWithPageNumber(HashMap<String, Object> map,
			@PathVariable(value = "pageNumber") String pageNumber) {
		int intPageNumber = 1;//default pageNumber
		if (pageNumber != null && !pageNumber.equals("")) {
			intPageNumber = Integer.valueOf(pageNumber);
		}

		PageHelper.startPage(intPageNumber, MAX_PAGE_NUMBER);
		List<HolderDataDTO> all = holderDataService.getAllJoinFH();
		PageInfo<HolderDataDTO> pageInfo = new PageInfo<>(all,
				MAX_NAV_PAGE_NUMBER);

		map.put("pageInfo", pageInfo);
		map.put("datas", all);
		map.put("type", ListFacade.HOLDERDATA);

		return FLASHCARDS + "/modelManagedPage";
	}
	//manage holderData end
}