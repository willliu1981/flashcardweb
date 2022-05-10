package idv.fc.taglib.tag.list;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.taglib.component.ListFacade;
import tool.Debug;

public class EachItemTag extends SimpleTagSupport {

	private ListFacade facade;
	private String var = "item";

	public void setListFacade(ListFacade facade) {
		this.facade = facade;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {

		while (this.facade.hasNextListItem()) {
			String listItem = facade.getListItem();
			this.getJspContext().setAttribute(var, listItem);

			try {
				this.getJspBody().invoke(null);
			} catch (JspException | IOException e) {
				throw new RuntimeException(e);
			}

			this.getJspContext().removeAttribute(var);
		}

	}

}
