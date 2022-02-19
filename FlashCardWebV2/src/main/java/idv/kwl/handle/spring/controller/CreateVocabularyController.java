package idv.kwl.handle.spring.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.component.SpringUtil;
import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.model.Vocabulary;

public class CreateVocabularyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VocabularyDao dao = (VocabularyDao) SpringUtil.getBean("VocabularyDao");
		Vocabulary voca = new Vocabulary();

		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		voca.setVid("v_" + qVoca);
		voca.setVocabulary(qVoca);
		voca.setTranslation(qTrans);
		voca.setCreate_date(Date.valueOf(LocalDate.now()));

		dao.create(voca);

		ModelAndView mv = new ModelAndView();

		System.out.println(this.getClass() + ": ");
		mv.setViewName("testresult");
		return mv;
	}

}
