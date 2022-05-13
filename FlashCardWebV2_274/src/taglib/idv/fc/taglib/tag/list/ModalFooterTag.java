package idv.fc.taglib.tag.list;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import idv.fc.taglib.impl.list.ListFacadeAdapter;
import idv.taglib.control.Handler;

public class ModalFooterTag extends ListTag {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringWriter sw = new StringWriter();

		String modalBody = facade.getModalFooter().getStrResult();

		this.getJspBody().invoke(sw);
		StringBuffer buffer = sw.getBuffer();

		String replace = modalBody.replace(Handler.BODY, buffer.toString());
		String close = facade.getModalFooter().getHandler()
				.getAttribute("btnCloseName").toString();
		replace = replace.replace("{btnCloseName}", close);

		out.print(replace);

	}
}
