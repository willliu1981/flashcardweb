package idv.fc.taglib.tag.listgroup;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.ListFacade;
import idv.fc.taglib.component.common.TaglibRenderer;

public class EachItemTag<T> extends SimpleTagSupport {

	private ListFacade<T> facade;
	private String var = "item";

	public void setListFacade(ListFacade<T> facade) {
		this.facade = facade;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {

		final JspWriter out = this.getJspContext().getOut();

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
