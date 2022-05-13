package idv.fc.taglib.tag.list;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import idv.debug.Debug;
import idv.fc.taglib.impl.list.ListFacadeAdapter;
import idv.taglib.control.Handler;
import idv.taglib.control.Result;

public class ModalFooterTag extends ListTag {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringWriter sw = new StringWriter();

		this.getJspBody().invoke(sw);
		StringBuffer buffer = sw.getBuffer();

		ListTag.processJspBodyReplacement(buffer,
				this.getFacade().getModalFooter());

		processRendererAttributeReplacement(buffer,
				this.getFacade().getModalFooter().getHandler());

		out.print(buffer.toString());
	}

}
