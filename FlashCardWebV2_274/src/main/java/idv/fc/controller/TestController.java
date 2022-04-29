package idv.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test1")
	public String query() {

		System.out.println("test1");
		return "test/test1";
	}

}
