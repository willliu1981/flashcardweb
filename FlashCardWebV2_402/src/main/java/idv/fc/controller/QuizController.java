package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.service.abstraction.IStatusService;

@Controller
@RequestMapping(value = "quiz")
public class QuizController extends BaseController {
	private String QUIZ = "quiz";

	@Autowired
	IFlashcardService flashcardService;

	@Autowired
	IFlashcardHolderService flashcardHolderService;

	@Autowired
	IHolderDataService holderDataService;

	@Autowired
	private IStatusService statusService;

	/*
	 * 管理 Quiz
	 */
	@RequestMapping(value = "quizManager")
	public String toQuizManager() {
		return QUIZ + "/" + "quizManagedPage.jsp";
	}

	@RequestMapping(value = "datas/{filter}/{mod}/{num}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> toGetStartDatas(
			@PathVariable("filter") String filter,
			@PathVariable("mod") String mod, @PathVariable("num") Integer num) {
		Map<String, Object> map = new HashMap<>();

		//經由strategy 取得datas
		List<HolderDataDTO> all = holderDataService.getAllJoinFH(filter, mod,
				num);

		List<Flashcard> collect = all.stream()
				.filter(x -> x.getFlashcardHolderDTO().getFlashcard() != null)
				.map(x -> x.getFlashcardHolderDTO().getFlashcard())
				.collect(Collectors.toList());

		JsonArray jArray = new JsonArray();
		collect.stream().forEach(x -> jArray.add(x.getId()));

		map.put("datas", collect);
		map.put("ids", jArray.toString());

		return map;
	}

	@RequestMapping(value = "{filter}/{mod}/{num}")
	public String toQuizStart(@PathVariable("filter") String filter,
			@PathVariable("mod") String mod, @PathVariable("num") Integer num,
			Map<String, Object> map) {

		toGetStartDatas(filter, mod, num).forEach((k, v) -> map.put(k, v));

		return "quiz/quizPlay.jsp";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toFinish() {

		return "quiz/quizFinish.jsp";
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> doFinish(String ids) {

		Integer[] arrIds = new Gson().fromJson(ids, Integer[].class);

		holderDataService.updateForQuizFinish(arrIds, "period");

		Map<String, String> result = new HashMap<>();
		result.put("code", "1");

		return result;
	}

}
