package idv.fc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import idv.fc.model.Flashcard;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.model.dto.simpledto.SimpleFlashcardsDTO;
import idv.fc.service.abstraction.IFlashcardHolderService;
import idv.fc.service.abstraction.IFlashcardService;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.service.abstraction.IStatusService;

@Controller
@RequestMapping(value = "*/quiz")
public class QuizController extends BaseController {
	private String QUIZ = "quiz";
	private final String FLASHCARDS = "flashcards";

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

	@RequestMapping(value = "data/{filter}/{mod}/{num}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> toGetStartDatas(
			@PathVariable("filter") String filter,
			@PathVariable("mod") String mod, @PathVariable("num") Integer num) {
		Map<String, Object> map = new HashMap<>();

		//經由strategy 取得datas
		List<HolderDataDTO> all = holderDataService
				.getAllJoinFHWithFilterAndMod(filter, mod, num);

		List<Integer> hdIds = all.stream().map(x -> x.getId())
				.collect(Collectors.toList());

		List<Flashcard> flashcards = all.stream()
				.filter(x -> hdIds.contains(x.getId()))
				.map(x -> x.getFlashcardHolderDTO().getFlashcard()).distinct()
				.collect(Collectors.toList());

		JsonArray jArray = new JsonArray();
		hdIds.stream().forEach(x -> jArray.add(x));

		map.put("data", flashcards);
		map.put("ids", jArray.toString());

		return map;
	}

	@RequestMapping(value = "{filter}/{mod}/{num}")
	public String toQuizStart(@PathVariable("filter") String filter,
			@PathVariable("mod") String mod, @PathVariable("num") Integer num,
			HttpSession session) {

		session.setAttribute("filter", filter);
		session.setAttribute("mod", mod);
		session.setAttribute("num", num);

		return "quiz/quizPlay.html";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String toFinish() {

		return "quiz/quizFinish.jsp";
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> doFinish(String ids, String filter) {

		Integer[] arrIds = new Gson().fromJson(ids, Integer[].class);

		holderDataService.updateForQuizFinish(arrIds, filter);

		Map<String, String> result = new HashMap<>();
		result.put("code", "1");

		return result;
	}

	/*
	 * 從quiz play 頁面 使用ajax 呼叫,用以取得 該 flashcards
	 */
	@RequestMapping(value = "simple/"
			+ FLASHCARDS, produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getFlashcardsWithFilterMod(
			HttpSession session) {

		String filter = session.getAttribute("filter").toString();
		String mod = session.getAttribute("mod").toString();
		Integer num = (Integer) session.getAttribute("num");

		HashMap<String, Object> jsonMap = new HashMap<>();

		SimpleFlashcardsDTO simpleFcs = new SimpleFlashcardsDTO();

		Map<String, Object> startDatas = toGetStartDatas(filter, mod, num);

		List<Flashcard> fcs = (List<Flashcard>) startDatas.get("data");

		Flashcard[] fcArray = new Flashcard[fcs.size()];
		fcs.toArray(fcArray);

		simpleFcs.setFlashcards(fcArray);
		simpleFcs.setIds((String) startDatas.get("ids"));
		simpleFcs.setFilter(filter);

		jsonMap.put("data", simpleFcs);

		return jsonMap;
	}

}
