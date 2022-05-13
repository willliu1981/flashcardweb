package idv.fc.taglib.tag.list;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.debug.Debug;
import idv.taglib.factory.ListFacade;

public class EachItemTag extends ListTag {
	private String var = "item";

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {

		while (this.getFacade().hasNextListItem()) {
			String listItem = getFacade().getListItem();
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
