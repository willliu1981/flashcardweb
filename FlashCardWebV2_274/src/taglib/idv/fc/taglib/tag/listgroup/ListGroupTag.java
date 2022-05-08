package idv.fc.taglib.tag.listgroup;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.common.TaglibRenderer;

public class ListGroupTag extends SimpleTagSupport {

	private Flashcard model;
	private TaglibRenderer listRenderer;
	StringWriter sw = new StringWriter();

	public void setModel(Flashcard model) {
		this.model = model;
	}

	public void setListRenderer(TaglibRenderer listRenderer) {
		this.listRenderer = listRenderer;
	}

	@Override
	public void doTag() throws JspException, IOException {

		final JspWriter out = this.getJspContext().getOut();
		this.getJspBody().invoke(sw);
		/*out.println(this.listRenderer.getRenderedResult(out));*/
		out.println("" + sw + " : " + this.model);
	}

}
