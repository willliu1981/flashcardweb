package idv.fc.boot.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class HelloController {

	@RequestMapping("hello")
	public String hello() {
		return "test xxx";
	}
}
