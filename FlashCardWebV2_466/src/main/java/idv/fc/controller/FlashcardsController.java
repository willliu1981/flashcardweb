package idv.fc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.CC;
import idv.debug.Debug;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;

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

	@RequestMapping(value = "fcsManager" ,method=RequestMethod.GET)
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
