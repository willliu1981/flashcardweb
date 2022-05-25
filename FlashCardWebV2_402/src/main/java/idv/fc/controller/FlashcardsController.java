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

import idv.debug.Debug;
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

	@RequestMapping(value = "fcsManager")
	public String toFlashcardsManager() {
		return FLASHCARDS + "/fcsManagedPage.jsp";
	}

	@RequestMapping(value = "fcManager")
	public String toFlashcardManager() {
		return FLASHCARDS + "/modelManager/flashcardManagedPage.html";
	}

	@RequestMapping(value = "fhManager")
	public String toFlashcardHolderManager() {
		return FLASHCARDS + "/modelManager/flashcardHolderManagedPage.html";
	}

	@RequestMapping(value = "hdManager")
	public String toHolderDataManager(HashMap<String, Object> map) {
		return FLASHCARDS + "/modelManager/holderDataManagedPage.html";
	}

}
