package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.debug.Debug;
import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FHDTO;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.FlashcardHolderListDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.tag.impl.facade.FlashcardHolderEditor;
import tool.toolkit.Toolkit;

@Controller
public class FlashcardHolderCRUDController extends BaseController {
	private static final Integer PAGE_HELPER_MAX_PAGE_NUMBER = 5;
	private static final Integer PAGE_INFO_MAX_NAV_PAGE_NUMBER = 5;
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base page
	protected String FLASHCARDHOLDER = "flashcardHolder";//jsp second-level page

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@RequestMapping(value = "flashcardHolders", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllFlashcardHolder() {
		return getAllFlashcardHolderWhitPageNum(null);
	}

	@RequestMapping(value = "flashcardHolders/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllFlashcardHolderWhitPageNum(
			@PathVariable("pageNum") Integer pageNum) {

		HashMap<String, Object> json = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}
		PageHelper.startPage(intPageNumber, PAGE_HELPER_MAX_PAGE_NUMBER);
		List<FlashcardHolderDTO> all = flashcardHolderService.getAllJoinFc();



		return json;
	}

	@RequestMapping(value = "flashcardHolder", method = RequestMethod.GET)
	public String toAdd(HashMap<String, Object> map) {
		map.put("data", new FlashcardHolder());
		map.put("erType", FlashcardHolderEditor.class);

		return FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	@RequestMapping(value = "flashcardHolder/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		FlashcardHolder find = flashcardHolderService.getById(id);

		map.put("data", find);
		map.put("erType", FlashcardHolderEditor.class);

		return FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "flashcardHolder", method = RequestMethod.POST)
	public String add(FlashcardHolder flashcardHolder) {

		if (flashcardHolder.getFcId() != null
				|| flashcardHolder.getId().equals("")) {
			flashcardHolder.setFcId(null);
		}
		flashcardHolderService.addNew(flashcardHolder);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = "flashcardHolder", method = RequestMethod.PUT)
	public String edit(FlashcardHolder flashcardHolder) {
		if (flashcardHolder.getFcId() == null
				|| flashcardHolder.getId().equals("")) {
			flashcardHolder.setFcId(null);
		}
		flashcardHolderService.edit(flashcardHolder);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = "flashcardHolder/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardHolderService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

}
