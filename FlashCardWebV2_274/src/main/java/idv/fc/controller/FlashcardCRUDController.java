package idv.fc.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.model.Flashcard;
import idv.fc.service.IFlashcardService;
import tool.idgenerator.IDGenerator;
import tool.spring.SpringUtil;

@Controller
public class FlashcardCRUDController {
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base page
	protected String FLASHCARD = "flashcard";//jsp second-level page

	protected static Logger logger = LoggerFactory
			.getLogger(FlashcardController.class);

	@Autowired
	IFlashcardService flashcardService;

	@RequestMapping(value = "flashcard", method = RequestMethod.GET)
	public String toAdd() {
		return FLASHCARDS + "/" + FLASHCARD + "/addFlashcardPage";
	}

	@RequestMapping(value = "flashcard/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		Flashcard find = flashcardService.getById(id);

		map.put("flashcard", find);
		return FLASHCARDS + "/" + FLASHCARD + "/editFlashcardPage";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "flashcard", method = RequestMethod.POST)
	public String add(Flashcard flashcard) {
		String term = flashcard.getTerm();
		IDGenerator IDGenerator = SpringUtil.getBean("IDGenerator",
				IDGenerator.class);
		String id = IDGenerator.generate(term, Flashcard.class);

		flashcard.setId(id);
		flashcardService.addNew(flashcard);

		return "redirect:" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = "flashcard", method = RequestMethod.PUT)
	public String edit(Flashcard flashcard) {

		logger.info("edit ...............");

		return "redirect:" + WEB_FLASHCARDS + "/fcManager";
	}

}
