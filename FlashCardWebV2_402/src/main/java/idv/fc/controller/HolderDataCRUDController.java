package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import idv.fc.model.HolderData;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.tag.impl.facade.HolderDataEditor;

@Controller
public class HolderDataCRUDController extends BaseController {
	private static final Integer PAGE_HELPER_MAX_PAGE_NUMBER = 5;
	private static final Integer PAGE_INFO_MAX_NAV_PAGE_NUMBER = 5;
	protected final String WEB_FLASHCARDS = "flashcards";//web base page
	protected final String PAGE_FLASHCARDS = "flashcards";//jsp/html base page
	protected final String HOLDERDATA = "holderData";//crud path
	protected final String HOLDERDATAS = "holderDatas";//crud path

	@Autowired
	IHolderDataService holderDataService;

	/*
	 * to crud page 
	 */

	@RequestMapping(value = HOLDERDATA, method = RequestMethod.GET)
	public String toAdd(HttpServletRequest request) {
		request.setAttribute("data", new HolderData());
		request.setAttribute("erType", HolderDataEditor.class);
		request.setAttribute("contextPath", request.getContextPath()); //***selected-list 修改這裡

		return PAGE_FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	@RequestMapping(value = HOLDERDATA + "/{id}", method = RequestMethod.GET)
	public String toEdit(@PathVariable("id") String id,
			HttpServletRequest request) {
		HolderData find = holderDataService.getById(id);

		request.setAttribute("data", find);
		request.setAttribute("erType", HolderDataEditor.class);
		request.setAttribute("contextPath", request.getContextPath()); //***selected-list 修改這裡

		return PAGE_FLASHCARDS + "/" + "modelEditPage.jsp";
	}

	/*
	 * process 
	 */

	@RequestMapping(value = HOLDERDATAS, produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllFlashcardHolder() {
		return getAllFlashcardHolderWhitPageNum(null);
	}

	@RequestMapping(value = HOLDERDATAS
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

		List<HolderDataDTO> queryResult = holderDataService.getAllJoinFH();

		PageInfo<HolderDataDTO> pageInfo = new PageInfo<>(queryResult,
				PAGE_INFO_MAX_NAV_PAGE_NUMBER);

		jsonMap.put("pageInfo", pageInfo);

		return jsonMap;
	}

	@RequestMapping(value = HOLDERDATA, method = RequestMethod.POST)
	public String add(HolderData model) {
		holderDataService.addNew(model);

		return "redirect:/" + WEB_FLASHCARDS + "/hdManager";
	}

	@RequestMapping(value = HOLDERDATA, method = RequestMethod.PUT)
	public String edit(HolderData model) {
		HolderData byId = holderDataService.getById(model.getId().toString());
		
		byId.setFhId(model.getFhId());
		
		holderDataService.edit(byId);

		return "redirect:/" + WEB_FLASHCARDS + "/hdManager";
	}

	@RequestMapping(value = HOLDERDATA + "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		holderDataService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/hdManager";
	}

}
