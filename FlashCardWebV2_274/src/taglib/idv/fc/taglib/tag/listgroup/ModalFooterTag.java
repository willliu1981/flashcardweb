package idv.fc.taglib.tag.listgroup;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.taglib.component.ListFacade;
import idv.fc.taglib.component.common.Renderable;
import tool.Debug;

public class ModalFooterTag extends SimpleTagSupport implements Renderable {
	private ListFacade facade;

	public void setListFacade(ListFacade facade) {
		this.facade = facade;
		this.facade.setContextPath(((PageContext) getJspContext())
				.getServletContext().getContextPath());

	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringWriter sw = new StringWriter();

		String modalBody = this.facade.getModalFooter();

		this.getJspBody().invoke(sw);
		StringBuffer buffer = sw.getBuffer();

		String replace = modalBody.replace(this.BODY, buffer.toString());

		out.print(replace);

	}
}
