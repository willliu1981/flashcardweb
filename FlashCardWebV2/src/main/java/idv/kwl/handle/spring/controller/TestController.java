package idv.kwl.handle.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.handle.connection.Connection;

public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		java.sql.Connection conn = Connection.getMysqlConnection();
		System.out.println(this.getClass() + ": conn=" + conn);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testresult");
		return null;
	}

}
