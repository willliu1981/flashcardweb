package idv.fc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import idv.fc.model.Flashcard;
import idv.fc.service.IFlashcardService;
import tool.idgenerator.IDGenerator;
import tool.spring.SpringUtil;

@Controller
public class FlashcardCRUDController extends BaseController {
	protected String WEB_FLASHCARDS = "flashcards";//web base page
	protected String FLASHCARDS = "flashcards";//jsp base page
	protected String FLASHCARD = "flashcard";//jsp second-level page

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
		/*		String id;
				// 創建ID 
				{
					String term = flashcard.getTerm();
					IDGenerator IDGenerator = SpringUtil.getBean("IDGenerator",
							IDGenerator.class);
					id = IDGenerator.generate(term, Flashcard.class);
		
		flashcard.setId(id);
				}*/
		flashcardService.addNew(flashcard);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = "flashcard", method = RequestMethod.PUT)
	public String edit(Flashcard flashcard) {
		flashcardService.edit(flashcard);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	@RequestMapping(value = "flashcard/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") String id) {
		flashcardService.remove(id);

		return "redirect:/" + WEB_FLASHCARDS + "/fcManager";
	}

	/*
	 * ajax
	 * (目前由 test3.jsp 呼叫)
	 */
	@RequestMapping(value = "ajax/flashcard/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getForAjax(HashMap<String, Object> map,
			@PathVariable("id") String id) {
		Flashcard find = flashcardService.getById(id);

		Gson g = new Gson();

		return g.toJson(find);
	}

}
