package idv.fc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;

@Controller
@RequestMapping(value = "*/flashcards")
public class FlashcardsController extends BaseController {
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp/html base path

	@Autowired
	IFlashcardService flashcardService;

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@Autowired
	IHolderDataService holderDataService;

	/*
	 * 管理 Flashcard & FlashcardHolder
	 */

	@RequestMapping(value = "fcsManager", method = RequestMethod.GET)
	public String toFlashcardsManager() {
		return FLASHCARDS + "/fcsManagedPage.jsp";
	}

	@RequestMapping(value = "fcManager", method = RequestMethod.GET)
	public String toFlashcardManager(HttpServletResponse resp) {
		resp.setHeader("Cache-Control", "no-cache");
		return FLASHCARDS + "/modelManager/flashcardManagedPage.html";
	}

	@RequestMapping(value = "fhManager", method = RequestMethod.GET)
	public String toFlashcardHolderManager(HttpServletResponse resp) {
		resp.setHeader("Cache-Control", "no-cache");
		return FLASHCARDS + "/modelManager/flashcardHolderManagedPage.html";
	}

	@RequestMapping(value = "hdManager", method = RequestMethod.GET)
	public String toHolderDataManager(HttpServletResponse resp) {
		resp.setHeader("Cache-Control", "no-cache");
		return FLASHCARDS + "/modelManager/holderDataManagedPage.html";
	}

	/**
	 * 使用post 防止頁面緩存
	 * 使用於 頁面是html 時, 取得 version
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "version", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getVersion(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("version", BaseController.getStaticVersion(request));
		return map;
	}

}
