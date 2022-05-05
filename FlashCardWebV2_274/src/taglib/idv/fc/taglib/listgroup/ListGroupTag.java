package idv.fc.taglib.listgroup;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.model.Flashcard;

public class ListGroupTag extends SimpleTagSupport {

	private ModelType type;
	private Flashcard model;

	public void setType(ModelType type) {
		this.type = type;
	}
	

	public void setModel(Flashcard model) {
		this.model = model;
	}


	@Override
	public void doTag() throws JspException, IOException {

		final JspWriter out = this.getJspContext().getOut();

		out.println("model type=" + this.model);
	}

}
