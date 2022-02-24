package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import idv.kwl.dao.concrete.VocabularyDao;
import idv.kwl.handle.controller.AttributeController;
import idv.kwl.handle.controller.VocabularyController;
import idv.kwl.model.Vocabulary;

public class DeleteVocabularyController extends VocabularyController<Vocabulary> {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String qID = request.getParameter("vid");

		this.getDao().delete(qID);

		System.out.println(this.getClass() + ": ");

		return super.handleRequest(request, response);
	}

}
