package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;
import idv.fc.model.dto.simpledto.SimpleVO;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.tag.impl.facade.FlashcardEditor;

@Controller
public class FlashcardCRUDController extends BaseController {
	private static final Integer PAGE_HELPER_MAX_PAGE_NUMBER = 5;
	private static final Integer PAGE_INFO_MAX_NAV_PAGE_NUMBER = 5;
	protected final String WEB_FLASHCARDS = "flashcards";//web base page
	protected final String PAGE_FLASHCARDS = "flashcards";//jsp/html base page
	protected final String FLASHCARD = "flashcard";//crud path
	protected final String FLASHCARDS = "flashcards";//crud path ; 注意與 FlashcardsController 的path 關係

	@Autowired
	IFlashcardService flashcardService;

	//注意: path flashcards 與 FlashcardsController 的path 關係

	/*
	 * to crud page
	 */

	@RequestMapping(value = FLASHCARD, method = RequestMethod.GET)
	public String toAdd(HashMap<String, Object> map) {
		map.put("data", new Flashcard());
		map.put("erType", FlashcardEditor.class);

		return PAGE_FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	@RequestMapping(value = FLASHCARD + "/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		Flashcard find = flashcardService.getById(id);

		map.put("data", find);
		map.put("erType", FlashcardEditor.class);

		return PAGE_FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	/*
	 * process 
	 */

	@RequestMapping(value = FLASHCARDS, produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcard() {
		return getAllFlashcardWhitPageNum(null);
	}

	@RequestMapping(value = FLASHCARDS
			+ "/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcardWhitPageNum(
			@PathVariable("pageNum") Integer pageNum) {

		HashMap<String, Object> jsonMap = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}
		PageHelper.startPage(intPageNumber, PAGE_HELPER_MAX_PAGE_NUMBER);
		List<Flashcard> queryResult = flashcardService.getAll();

		PageInfo<Flashcard> pageInfo = new PageInfo<>(queryResult,
				PAGE_INFO_MAX_NAV_PAGE_NUMBER);

		jsonMap.put("pageInfo", pageInfo);

		return jsonMap;
	}

	@RequestMapping(value = FLASHCARD, method = RequestMethod.POST)
	public String add(Flashcard flashcard) {
		flashcardService.addNew(flashcard);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = FLASHCARD, method = RequestMethod.PUT)
	public String edit(Flashcard flashcard) {
		flashcardService.edit(flashcard);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = FLASHCARD + "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	/*
	 * 從flashcard holder edit 的處理頁面 使用ajax 呼叫,用以取得 該model 的list
	 */
	@RequestMapping(value = "simple/"
			+ FLASHCARDS, produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcardForSelectedList() {
		return getAllFlashcardForSelectedListWhitPageNum(null);
	}

	/*
	 * 從flashcard holder edit 的處理頁面 使用ajax 呼叫,用以取得 該model 的list
	 */
	@RequestMapping(value = "simple/" + FLASHCARDS
			+ "/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcardForSelectedListWhitPageNum(
			@PathVariable("pageNum") Integer pageNum) {

		HashMap<String, Object> jsonMap = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}
		PageHelper.startPage(intPageNumber, PAGE_HELPER_MAX_PAGE_NUMBER);
		List<Flashcard> queryResult = flashcardService.getAll();

		PageInfo<Flashcard> pageInfo = new PageInfo<>(queryResult,
				PAGE_INFO_MAX_NAV_PAGE_NUMBER);

		SimplePageInfoDTO dto = new SimplePageInfoDTO();
		dto.setHasNextPage(pageInfo.isHasNextPage());
		dto.setHasPreviouPage(pageInfo.isHasPreviousPage());
		dto.setIsLastPage(pageInfo.isIsLastPage());
		dto.setPageNum(pageInfo.getPageNum());
		dto.setNavigateLastPage(pageInfo.getNavigateLastPage());

		List<SimpleVO> collect = pageInfo.getList().stream()
				.map(x -> new SimpleVO(x.getId().toString(), x.getTerm()))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		jsonMap.put("pageInfo", dto);

		return jsonMap;
	}

}
