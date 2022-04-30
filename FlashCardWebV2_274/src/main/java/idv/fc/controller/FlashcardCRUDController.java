package idv.fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.model.Flashcard;
import idv.fc.service.IFlashcardService;

@Controller
@RequestMapping(value = "flashcard")
public class FlashcardCRUDController {
	@Autowired
	IFlashcardService flashcardService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toAdd() {
		return "flashcard/addFlashcardPage";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(Flashcard flashcard) {
		String term=flashcard.getTerm();
		//term.
		
		//flashcard.setId(null);
		//flashcardService.addNew(flashcard);

		return "../flashcardDetail";
	}

}
