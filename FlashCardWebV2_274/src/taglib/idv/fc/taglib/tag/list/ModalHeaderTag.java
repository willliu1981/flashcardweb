package idv.fc.taglib.tag.list;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class ModalHeaderTag extends ListTag {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print(this.getFacade().getModalHeader());

	}

}
