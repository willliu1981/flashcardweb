package idv.kwl.handle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public abstract class AttributeController implements Controller {

	private String viewName;
	private ModelAndView mv;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName(this.getViewName());
		handleRequestImpl(request, response, mv);
		return mv;
	}

	public abstract void handleRequestImpl(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception;

	protected String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	protected ModelAndView getModelAndView() {
		if (this.mv == null) {
			this.mv = new ModelAndView();
		}
		return new ModelAndView();
	}

	protected void start() {
		this.mv = null;
	}

}
