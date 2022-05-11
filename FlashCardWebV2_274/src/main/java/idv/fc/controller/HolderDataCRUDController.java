package idv.fc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idv.fc.model.HolderData;
import idv.fc.service.abstraction.IHolderDataService;

@Controller
public class HolderDataCRUDController extends BaseController {
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base page
	protected String FLASHCARDHOLDER = "holderData";//jsp second-folder-path page

	@Autowired
	IHolderDataService holderDataService;

	@RequestMapping(value = "holderData", method = RequestMethod.GET)
	public String toAdd() {
		return FLASHCARDS + "/" + FLASHCARDHOLDER + "/addHolderDataPage";
	}

	@RequestMapping(value = "holderData/{id}", method = RequestMethod.GET)
	public String toEdit(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		HolderData find = holderDataService.getById(id);

		map.put("holderData", find);
		return FLASHCARDS + "/" + FLASHCARDHOLDER + "/editHolderDataPage";
	}

	/*
	 * process begin
	 */
	@RequestMapping(value = "holderData", method = RequestMethod.POST)
	public String add(HolderData model) {
		holderDataService.addNew(model);

		return "redirect:/" + WEB_FLASHCARDS + "/hdManager";
	}

	@RequestMapping(value = "holderData", method = RequestMethod.PUT)
	public String edit(HolderData model) {
		holderDataService.edit(model);

		return "redirect:/" + WEB_FLASHCARDS + "/hdManager";
	}

	@RequestMapping(value = "holderData/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		holderDataService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/hdManager";
	}

}