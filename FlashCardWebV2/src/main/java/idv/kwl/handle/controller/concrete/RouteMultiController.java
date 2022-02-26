package idv.kwl.handle.controller.concrete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "page")
public class RouteMultiController {

	@RequestMapping(value = "vocabulary")
	public String route() {
		
		return "vocabulary";
	}
	
	@RequestMapping(value = "vocabulary/add")
	public String route1() {

		return "createVocabulary";
	}
}
