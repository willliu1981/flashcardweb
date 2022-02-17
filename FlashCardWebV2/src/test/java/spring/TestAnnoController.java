package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("spring")
public class TestAnnoController {

	String testx;

	@RequestMapping(method = RequestMethod.GET)
	public String test1(ModelAndView mv) {
		System.out.println(this.getClass() + " :test1 :" + this.testx);
		return "testresult";
	}

	public void setTestx(String str) {
		this.testx = str;
	}
}
