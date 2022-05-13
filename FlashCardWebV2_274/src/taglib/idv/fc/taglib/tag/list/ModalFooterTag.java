package idv.fc.taglib.tag.list;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import idv.fc.taglib.impl.list.ListFacadeAdapter;
import idv.taglib.component.itf.Renderable;
import tool.Debug;

public class ModalFooterTag extends ListTag implements Renderable {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringWriter sw = new StringWriter();

		ListFacadeAdapter facade = (ListFacadeAdapter) this.getFacade();

		String modalBody = facade.getModalFooter2().getStrResult();

		this.getJspBody().invoke(sw);
		StringBuffer buffer = sw.getBuffer();

		String replace = modalBody.replace(this.BODY, buffer.toString());
		String close = facade.getModalFooter2().getHandler()
				.getAttribute("btnCloseName").toString();
		replace = replace.replace("{btnCloseName}", close);

		out.print(replace);

	}
}
