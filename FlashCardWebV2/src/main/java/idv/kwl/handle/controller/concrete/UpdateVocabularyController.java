package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.bean.factory.SpringUtil;
import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.handle.controller.AttributeController;
import idv.kwl.model.Vocabulary;

public class UpdateVocabularyController extends AttributeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VocabularyDao dao = (VocabularyDao) SpringUtil.getBean("VocabularyDao");
		Vocabulary voca = new Vocabulary();

		String qVid = request.getParameter("vid");
		String qVoca = request.getParameter("vocabulary");
		String qTrans = request.getParameter("translation");

		voca.setVid("v_" + qVoca.trim());
		voca.setVocabulary(qVoca);
		voca.setTranslation(qTrans);

		dao.update(voca, qVid);

		ModelAndView mv = new ModelAndView();

		System.out.println(this.getClass() + ": ");
		mv.setViewName("testresult");
		return mv;
	}

}
