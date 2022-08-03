package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import idv.fc.model.Flashcard;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;
import idv.fc.service.abstraction.IFlashcardService;

@Controller
@RequestMapping(value = "*/")
public class FlashcardCRUDController extends BaseController {
	private static final Integer PAGESIZE = 5;
	private static final Integer NAVIGATE_PAGES = 5;
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
	public String toAdd(HttpServletResponse res) {

		res.addHeader("Cache-Control", "no-cache");
		return PAGE_FLASHCARDS + "/modelEditor/" + "flashcardAddPage.html";
	}

	@RequestMapping(value = FLASHCARD + "/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id, HttpSession session,HttpServletResponse res) {
		session.setAttribute("flashcardEditId", id);
		
		res.addHeader("Cache-Control", "no-cache");
		return PAGE_FLASHCARDS + "/modelEditor/" + "flashcardEditPage.html";
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

		Page<Object> startPage = PageHelper.startPage(intPageNumber, PAGESIZE);

		SimplePageInfoDTO pageInfo = flashcardService
				.getAllWithSimplePageInfoDTO(startPage, NAVIGATE_PAGES);

		jsonMap.put("pageInfo", pageInfo);

		return jsonMap;
	}

	@RequestMapping(value = FLASHCARD, method = RequestMethod.POST)
	public String add(Flashcard flashcard, HttpServletRequest request) {
		flashcardService.addNew(flashcard);

		return "redirect:/" + BaseController.getStaticVersion(request) + "/"
				+ WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = FLASHCARD, method = RequestMethod.PUT)
	public String edit(Flashcard flashcard, HttpServletRequest request) {
		Flashcard byId = flashcardService.getById(flashcard.getId().toString());

		byId.setTerm(flashcard.getTerm());
		byId.setDefinition(flashcard.getDefinition());

		flashcardService.edit(byId);

		return "redirect:/" + BaseController.getStaticVersion(request) + "/"
				+ WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = FLASHCARD + "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id,
			HttpServletRequest request) {
		flashcardService.remove(id);

		return "redirect:/" + BaseController.getStaticVersion(request) + "/"
				+ WEB_FLASHCARDS + "/fcManager";
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

		Page<Object> startPage = PageHelper.startPage(intPageNumber, PAGESIZE);

		SimplePageInfoDTO allWithSimplePageInfoDTO = flashcardService
				.getAllWithSimplePageInfoDTORequireCitedNumsArray(startPage,
						NAVIGATE_PAGES);

		jsonMap.put("pageInfo", allWithSimplePageInfoDTO);

		return jsonMap;

		/*HashMap<String, Object> jsonMap = new HashMap<>();
		
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
		
		return jsonMap;*/
	}

	//判斷是否有重複
	@RequestMapping(value = FLASHCARD
			+ "/byTerm/{term}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> queryByTerm(
			@PathVariable("term") String term) {
		HashMap<String, Object> jsonMap = new HashMap<>();

		Flashcard byTerm = this.flashcardService.getByTerm(term);
		if (byTerm != null) {
			jsonMap.put("isExist", true);
		} else {
			jsonMap.put("isExist", false);
		}

		return jsonMap;
	}

	/**
	 * for search
	 * query by like condition(no pageNum and auto create pageNum
	 * @param pattern
	 * @return
	 */
	@RequestMapping(value = FLASHCARD
			+ "/like/{pattern}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> queryByTermOrDefinitionUsingLikeCondition(
			@PathVariable("pattern") String pattern) {

		Integer searchPageNum = this.flashcardService.getSearchPageNum(PAGESIZE,
				pattern);
		HashMap<String, Object> map = this
				.queryByTermOrDefinitionUsingLikeCondition(pattern,
						searchPageNum);
		SimplePageInfoDTO pageInfo = (SimplePageInfoDTO) map.get("pageInfo");

		return map;
	}

	/**
	 * for search
	 * query by like condition (pageNum)
	 * @param pattern
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = FLASHCARD
			+ "/like/{pattern}/{pageNum}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> queryByTermOrDefinitionUsingLikeCondition(
			@PathVariable("pattern") String pattern,
			@PathVariable("pageNum") Integer pageNum) {
		HashMap<String, Object> jsonMap = new HashMap<>();

		int intPageNumber = 1;//default pageNumber
		if (pageNum != null && !pageNum.equals("")) {
			intPageNumber = Integer.valueOf(pageNum);
		}

		Page<Object> startPage = PageHelper.startPage(intPageNumber, PAGESIZE);

		SimplePageInfoDTO pageInfo = this.flashcardService
				.getByTermUsingLikeCondition(startPage, NAVIGATE_PAGES,
						pattern);

		jsonMap.put("pageInfo", pageInfo);

		return jsonMap;
	}

	/**
	 * flashcardEditPage 回顯data
	 */
	@RequestMapping(value = FLASHCARD
			+ "/echo", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getById(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Flashcard result = this.flashcardService
				.getById(session.getAttribute("flashcardEditId").toString());

		map.put("data", result);

		return map;
	}
}
