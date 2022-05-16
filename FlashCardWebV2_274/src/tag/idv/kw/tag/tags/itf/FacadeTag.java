package idv.kw.tag.tags.itf;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.kw.tag.factory.TagFactory;
import idv.kw.tag.itf.TagFacade;
import idv.kw.tag.model.Attribute;

public abstract class FacadeTag extends SimpleTagSupport {

	private TagFacade facade;

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		Attribute attribute = this.getFacade().getAttributes();

		this.getJspBody().invoke(sw);
		this.processAttribute(sw.getBuffer(), attribute);
		this.getJspContext().getOut().print(sw.getBuffer().toString());
	}

	protected StringBuffer processAttribute(StringBuffer buffer,
			Attribute attribute) {
		attribute.forEach((k, v) -> {
			Pattern compile = Pattern.compile("\\{[ ]*" + k + "[ ]*\\}");
			Matcher matcher = compile.matcher(buffer.toString());
			String replaceAll = matcher.replaceAll(v);
			buffer.setLength(0);
			buffer.append(replaceAll);
		});

		return buffer;
	}

	public TagFacade getFacade() {
		return facade;
	}

	public void setFacade(TagFacade facade) {
		this.facade = facade;
	}

}
