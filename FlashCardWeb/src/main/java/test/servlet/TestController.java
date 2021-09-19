package test.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.flashcard.control.Controller;

public class TestController extends Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String v = request.getParameter("v");

		System.out.println("xxxxx " + v);
		return null;
	}

}
