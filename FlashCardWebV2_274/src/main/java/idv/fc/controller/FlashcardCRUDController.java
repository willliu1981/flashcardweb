package idv.fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.model.Flashcard;
import idv.fc.service.IFlashcardService;
import tool.idgenerator.IDGenerator;
import tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "flashcard")
public class FlashcardCRUDController {
	protected String FLASHCARDS = "flashcards";

	@Autowired
	IFlashcardService flashcardService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toAdd() {
		return FLASHCARDS + "/addFlashcardPage";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(Flashcard flashcard) {
		String term = flashcard.getTerm();
		IDGenerator IDGenerator = SpringUtil.getBean("IDGenerator",
				IDGenerator.class);
		String id = IDGenerator.generate(term, Flashcard.class);

		flashcard.setId(id);
		flashcardService.addNew(flashcard);

		return "redirect:" + FLASHCARDS + "/fcManager";
	}

}
