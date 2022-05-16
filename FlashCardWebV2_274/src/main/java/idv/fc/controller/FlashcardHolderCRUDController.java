package idv.fc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.model.FlashcardHolder;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.tag.impl.facade.FlashcardHolderEditor;

@Controller
public class FlashcardHolderCRUDController extends BaseController {
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base page
	protected String FLASHCARDHOLDER = "flashcardHolder";//jsp second-level page

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@RequestMapping(value = "flashcardHolder", method = RequestMethod.GET)
	public String toAdd(HashMap<String, Object> map) {
		map.put("data", new FlashcardHolder());
		map.put("erType", FlashcardHolderEditor.class);

		return FLASHCARDS + "/" + "modelEditPage";
	}

	@RequestMapping(value = "flashcardHolder/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		FlashcardHolder find = flashcardHolderService.getById(id);

		map.put("data", find);
		map.put("erType", FlashcardHolderEditor.class);

		return FLASHCARDS + "/" + "modelEditPage";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "flashcardHolder", method = RequestMethod.POST)
	public String add(FlashcardHolder flashcardHolder) {
		if (flashcardHolder.getFcId() != null
				|| flashcardHolder.getId().equals("")) {
			flashcardHolder.setFcId(null);
		}
		flashcardHolderService.addNew(flashcardHolder);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = "flashcardHolder", method = RequestMethod.PUT)
	public String edit(FlashcardHolder flashcardHolder) {
		if (flashcardHolder.getFcId() == null
				|| flashcardHolder.getId().equals("")) {
			flashcardHolder.setFcId(null);
		}
		flashcardHolderService.edit(flashcardHolder);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

	@RequestMapping(value = "flashcardHolder/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardHolderService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fhManager";
	}

}
