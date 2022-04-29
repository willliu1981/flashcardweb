package idv.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "flashcard")
public class FlashcardCRUDController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String toAdd() {

		return "flashcard/addFlashcardPage";
	}

}
