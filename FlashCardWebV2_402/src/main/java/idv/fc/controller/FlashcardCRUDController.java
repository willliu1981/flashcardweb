package idv.fc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.tag.impl.facade.FlashcardEditor;

@Controller
public class FlashcardCRUDController extends BaseController {
	private static final Integer PAGE_HELPER_MAX_PAGE_NUMBER = 5;
	private static final Integer PAGE_INFO_MAX_NAV_PAGE_NUMBER = 5;
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base page
	protected String FLASHCARD = "flashcard";//jsp second-level page

	@Autowired
	IFlashcardService flashcardService;

	/**
	 * path flashcards : 注意與 FlashcardController 的path 關係
	 * @param map
	 * @return
	 */

	@RequestMapping(value = "flashcards", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcard() {

		/*		HashMap<String, Object> json = new HashMap<>();
		
				int intPageNumber = 3;//default pageNumber
				PageHelper.startPage(intPageNumber, PAGE_HELPER_MAX_PAGE_NUMBER);
				List<Flashcard> all = flashcardService.getAll();
				PageInfo<Flashcard> pageInfo = new PageInfo<>(all,
						PAGE_INFO_MAX_NAV_PAGE_NUMBER);
		
				json.put("datas", all);
				json.put("pageInfo", pageInfo);
		
				Debug.test(new Object() {
				}, "info", pageInfo);
		*/
		return getAllFlashcardWhitPageNum(null);
	}

	@RequestMapping(value = "flashcards/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcardWhitPageNum(
			@PathVariable("pageNum") Integer pageNum) {

		HashMap<String, Object> json = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}
		PageHelper.startPage(intPageNumber, PAGE_HELPER_MAX_PAGE_NUMBER);
		List<Flashcard> all = flashcardService.getAll();
		PageInfo<Flashcard> pageInfo = new PageInfo<>(all,
				PAGE_INFO_MAX_NAV_PAGE_NUMBER);

		json.put("pageInfo", pageInfo);

		Debug.test(new Object() {
		}, "info", pageInfo.getList());

		return json;
	}

	@RequestMapping(value = "flashcard", method = RequestMethod.GET)
	public String toAdd(HashMap<String, Object> map) {
		map.put("data", new Flashcard());
		map.put("erType", FlashcardEditor.class);

		return FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	@RequestMapping(value = "flashcard/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		Flashcard find = flashcardService.getById(id);

		map.put("data", find);
		map.put("erType", FlashcardEditor.class);

		return FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "flashcard", method = RequestMethod.POST)
	public String add(Flashcard flashcard) {
		flashcardService.addNew(flashcard);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = "flashcard", method = RequestMethod.PUT)
	public String edit(Flashcard flashcard) {
		flashcardService.edit(flashcard);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = "flashcard/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

}
