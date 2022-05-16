package idv.kw.tag.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.kw.tag.facade.Editor;
import idv.kw.tag.factory.TagFactory;
import idv.kw.tag.itf.TagFacade;
import idv.kw.tag.model.Attribute;

public class FormTag extends SimpleTagSupport {

	private Class<?> type;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		Attribute attribute = this.getFacade().getAttribute();
		String string = attribute.get("formTitle");

		this.getJspBody().invoke(out);

	}

	public void setType(Class<?> editorType) {
		this.type = editorType;
	}

	protected TagFacade getFacade() {
		return TagFactory.getFacade(null, Editor.class);
	}

}
