package idv.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tool.Debug;

@Controller
@RequestMapping(value = "word")
public class WordController {

	@RequestMapping(value = "wordManager")
	public String toCardManager() {

		return "wordManager/managedPage";
	}

	@RequestMapping(value = "word")
	public String toWord() {
		return "wordManager/wordManagedPage";
	}

	@RequestMapping(value = "card")
	public String toCard() {

		return "wordManager/cardManagedPage";
	}

}
