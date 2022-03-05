package idv.kwl.handle.controller.concrete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "draw")
	public String test() {


		return "testdraw";
	}
	
}
