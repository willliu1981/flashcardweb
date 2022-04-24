package idv.fc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.fc.pojo.Vocabulary;

@Controller
@RequestMapping(value = "word")
public class WordController {

	@RequestMapping(value = "wordManager")
	public String toCardManager() {
		return "wordManager/managedPage";
	}

	@RequestMapping(value = "vocabulary")
	public String toWord(HashMap<String, List<Vocabulary>> map) {
	SpringUtil .
		map.put("vocabularys", vocabularys);

		return "wordManager/vocabularyManagedPage";
	}

	@RequestMapping(value = "card")
	public String toCard() {

		return "wordManager/cardManagedPage";
	}

}
