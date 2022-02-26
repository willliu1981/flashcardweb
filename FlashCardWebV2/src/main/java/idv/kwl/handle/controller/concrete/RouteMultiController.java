package idv.kwl.handle.controller.concrete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "word")
public class RouteMultiController {

	
	@RequestMapping(value = "add")
	public String route() {
		
		return null;
	}
}
