package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.tag.impl.facade.FlashcardHolderEditor;

@Controller
public class FlashcardHolderCRUDController extends BaseController {
	private static final Integer PAGE_HELPER_MAX_PAGE_NUMBER = 5;
	private static final Integer PAGE_INFO_MAX_NAV_PAGE_NUMBER = 5;
	protected final String WEB_FLASHCARDS = "flashcards";//web base page
	protected final String PAGE_FLASHCARDS = "flashcards";//jsp/html base page
	protected final String FLASHCARDHOLDER = "flashcardHolder";//crud path
	protected final String FLASHCARDHOLDERS = "flashcardHolders";//crud path

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	/*
	 * to crud page
	 */

	@RequestMapping(value = FLASHCARDHOLDER, method = RequestMethod.GET)
	public String toAdd(HashMap<String, Object> map) {
		map.put("data", new FlashcardHolder());
		map.put("erType", FlashcardHolderEditor.class);

		return PAGE_FLASHCARDS + "/modelEditPage.jsp";
	}

	@RequestMapping(value = FLASHCARDHOLDER
			+ "/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		FlashcardHolder find = flashcardHolderService.getById(id);

		map.put("data", find);
		map.put("erType", FlashcardHolderEditor.class);

		return PAGE_FLASHCARDS + "/modelEditPage.jsp";
	}

	/*
	 * process 
	 */

	@RequestMapping(value = FLASHCARDHOLDERS, produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllFlashcardHolder() {
		return getAllFlashcardHolderWhitPageNum(null);
	}

	@RequestMapping(value = FLASHCARDHOLDERS
			+ "/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllFlashcardHolderWhitPageNum(
			@PathVariable("pageNum") Integer pageNum) {

		HashMap<String, Object> jsonMap = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}
		PageHelper.startPage(intPageNumber, PAGE_HELPER_MAX_PAGE_NUMBER);

		List<FlashcardHolderDTO> queryResult = flashcardHolderService
				.getAllJoinFc();

		PageInfo<FlashcardHolderDTO> pageInfo = new PageInfo<>(queryResult,
				PAGE_INFO_MAX_NAV_PAGE_NUMBER);

		jsonMap.put("pageInfo", pageInfo);

		return jsonMap;
	}

	@RequestMapping(value =FLASHCARDHOLDER, method = RequestMethod.POST)
	public String add(FlashcardHolder flashcardHolder) {

		if (flashcardHolder.getFcId() != null
				&& flashcardHolder.getFcId().equals("")) {
			flashcardHolder.setFcId(null);
		}
		flashcardHolderService.addNew(flashcardHolder);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = FLASHCARDHOLDER, method = RequestMethod.PUT)
	public String edit(FlashcardHolder flashcardHolder) {
		if (flashcardHolder.getFcId() == null
				|| flashcardHolder.getId().equals("")) {
			flashcardHolder.setFcId(null);
		}
		flashcardHolderService.edit(flashcardHolder);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = FLASHCARDHOLDER+"/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardHolderService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

}
