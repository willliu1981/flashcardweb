package idv.kw.tag.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.debug.Debug;
import idv.fc.model.Flashcard;
import idv.kw.tag.factory.TagFactory;
import idv.kw.tag.itf.TagFacade;
import idv.kw.tag.model.Attribute;

public class FormTag<T extends TagFacade> extends SimpleTagSupport {

	private Class<T> type;
	private String data;
	private String var;

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		Attribute attribute = this.getFacade().getAttributes();

		this.getJspBody().invoke(sw);
		this.processAttribute(sw.getBuffer(), attribute);
		this.getJspContext().getOut().print(sw.getBuffer().toString());
	}

	public void setType(Class<T> editorType) {
		this.type = editorType;
	}

	protected TagFacade getFacade() {
		HttpServletRequest request = (HttpServletRequest) ((PageContext) this
				.getJspContext()).getRequest();
		Object attribute = request.getAttribute(data);
		return TagFactory.getFacade(attribute, type, attribute.getClass());
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

	public void setData(String data) {
		this.data = data;
	}

	public void setVar(String var) {
		this.var = var;
	}

}
