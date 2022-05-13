package idv.fc.taglib.tag.list;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import idv.debug.Debug;
import idv.fc.taglib.impl.list.ListFacadeAdapter;
import idv.taglib.control.Handler;

public class ModalFooterTag extends ListTag {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringWriter sw = new StringWriter();

		String modalBody = this.getFacade().getModalFooter().getStrResult();
		this.getJspBody().invoke(sw);
		StringBuffer buffer = sw.getBuffer();
		String jspBody = buffer.toString();

		//將jspBody 取代 Handler.BODY 佔位符
		buffer.setLength(0);
		buffer.append(modalBody);
		int indexOf = buffer.indexOf(Handler.BODY);
		buffer.replace(indexOf, indexOf + Handler.BODY.length(), jspBody);

		Handler handler = this.getFacade().getModalFooter().getHandler();

		handler.getAttributes().forEach((k, v) -> {
			int idx = buffer.indexOf(k);
			buffer.replace(idx - 1, idx + k.length() + 1, v);
		});

		out.print(buffer.toString());

	}
}
