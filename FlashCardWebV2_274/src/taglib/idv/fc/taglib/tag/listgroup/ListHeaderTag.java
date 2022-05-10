package idv.fc.taglib.tag.listgroup;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.taglib.component.ListFacade;
import tool.Debug;

public class ListHeaderTag extends SimpleTagSupport {
	private ListFacade facade;

	public void setListFacade(ListFacade facade) {
		this.facade = facade;
		String contextPath = ((PageContext) getJspContext()).getServletContext()
				.getContextPath();
		this.facade.setContextPath(contextPath);
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print(this.facade.getListHeader());

	}

}
