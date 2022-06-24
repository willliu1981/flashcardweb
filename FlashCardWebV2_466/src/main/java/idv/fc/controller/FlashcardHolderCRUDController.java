package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.CC;
import idv.debug.Debug;
import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;

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
	public String toAdd() {

		return PAGE_FLASHCARDS + "/modelEditor/"
				+ "flashcardHolderAddPage.html";
	}

	@RequestMapping(value = FLASHCARDHOLDER
			+ "/{id}", method = RequestMethod.POST) //使用post 以解決瀏覽器緩存問題
	public String toEdit(@PathVariable("id") String id, HttpSession session) {
		session.setAttribute("id", id);

		return PAGE_FLASHCARDS + "/modelEditor/"
				+ "flashcardHolderEditPage.html";
	}

	/**
	 * flashcardHolderAddPage 回顯data
	 */
	@RequestMapping(value = FLASHCARDHOLDER
			+ "/echo", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getById(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		FlashcardHolderDTO result = this.flashcardHolderService
				.getDTOById(session.getAttribute("id").toString());

		map.put("data", result);

		return map;
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

	@RequestMapping(value = FLASHCARDHOLDER, method = RequestMethod.POST)
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

		FlashcardHolder byId = flashcardHolderService
				.getById(flashcardHolder.getId().toString());
		byId.setName(flashcardHolder.getName());
		byId.setFcId(flashcardHolder.getFcId());

		flashcardHolderService.edit(byId);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = FLASHCARDHOLDER
			+ "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardHolderService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	/*
	 * 從holder data edit 的處理頁面 使用ajax 呼叫,用以取得 該model 的list
	 */
	@RequestMapping(value = "simple/"
			+ FLASHCARDHOLDERS, produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcardHolderForSelectedList() {
		return getAllFlashcardHolderForSelectedListWhitPageNum(null);
	}

	/*
	 * 從holder data edit 的處理頁面 使用ajax 呼叫,用以取得 該model 的list
	 */
	@RequestMapping(value = "simple/" + FLASHCARDHOLDERS
			+ "/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getAllFlashcardHolderForSelectedListWhitPageNum(
			@PathVariable("pageNum") Integer pageNum) {

		HashMap<String, Object> jsonMap = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}

		Page<Object> startPage = PageHelper.startPage(intPageNumber,
				PAGE_HELPER_MAX_PAGE_NUMBER);

		SimplePageInfoDTO allWithSimplePageInfoDTO = flashcardHolderService
				.getAllWithSimplePageInfoDTO(startPage,
						PAGE_INFO_MAX_NAV_PAGE_NUMBER);

		jsonMap.put("pageInfo", allWithSimplePageInfoDTO);

		return jsonMap;
	}

}
