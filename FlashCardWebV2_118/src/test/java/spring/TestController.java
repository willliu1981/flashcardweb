package spring;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import idv.fc.dao.VocabularyDao;
import idv.fc.model.Vocabulary;
import idv.fc.model.proxy.IVocabulary;

public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		VocabularyDao dao = new VocabularyDao();
		Vocabulary voca = new Vocabulary();

		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		voca.setId("v_" + qVoca);
		voca.setVocabulary(qVoca);
		voca.setTranslation(qTrans);
		voca.setCreate_date(Date.valueOf(LocalDate.now()));

		dao.create(voca);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("testresult");
		return mv;
	}

}
