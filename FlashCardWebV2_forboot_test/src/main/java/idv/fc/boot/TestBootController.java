package idv.fc.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBootController {

	@RequestMapping("testboot")
	public String testBoot() {
		return "boot test2";
	}
}
