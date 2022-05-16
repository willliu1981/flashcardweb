package idv.fc.taglib.tag.lister;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.debug.Debug;
import idv.taglib.factory.lister.ListFacade;

public class ListHeaderTag extends ListTag {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print(this.getFacade().getListHeader().getStrResult());

	}
}
