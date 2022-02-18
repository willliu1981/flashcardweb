package idv.kwl.handle.spring.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.handle.dao.concrete.VocabularyDao;
import idv.kwl.model.Vocabulary;

public class DeleteVocabularyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VocabularyDao dao = new VocabularyDao();
		Vocabulary voca = new Vocabulary();

		String qID = request.getParameter("vid");

		dao.delete(qID);

		ModelAndView mv = new ModelAndView();

		System.out.println(this.getClass() + ": ");
		mv.setViewName("testresult");
		return mv;
	}

}
