package idv.kwl.handle.controller.concrete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "page")
public class RouteMultiController {

	@RequestMapping(value = "vocabulary")
	public String vocabulary() {

		return "vocabulary/vocabulary";
	}

	@RequestMapping(value = "vocabulary/add")
	public String vocabularyAdd() {

		return "vocabulary/createVocabulary";
	}

	@RequestMapping(value = "vocabulary/update")
	public String vocabularyUpdate() {

		return "vocabulary/updateVocabulary";
	}

	@RequestMapping(value = "vocabulary/delete")
	public String vocabularyDelete() {

		return "vocabulary/deleteVocabulary";
	}

	@RequestMapping(value = "vocabulary/query")
	public String vocabularyQueryAll() {

		return "vocabulary/queryVocabulary";
	}
}
