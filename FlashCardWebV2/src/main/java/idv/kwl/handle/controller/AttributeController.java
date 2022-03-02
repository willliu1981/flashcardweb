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
		this.getModelAndView().setViewName(this.getViewName());

		return mv;
	}

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
		return mv;
	}

	protected void start() {
		this.mv = null;
	}

}
