package idv.fc.taglib.tag.list;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.taglib.component.ListFacade;

public class ModalHeaderTag extends SimpleTagSupport {
	private ListFacade facade;

	public void setListFacade(ListFacade facade) {
		this.facade = facade;
		this.facade.setContextPath(((PageContext) getJspContext())
				.getServletContext().getContextPath());

	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print(this.facade.getModalHeader());

	}

}
