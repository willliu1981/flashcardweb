package idv.fc.taglib.tag.lister;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import idv.debug.Debug;
import idv.taglib.controlmodel.Handler;
import idv.taglib.controlmodel.Result;
import idv.taglib.factory.lister.ListFacadeAdapter;

public class ModalFooterTag extends ListTag {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringWriter sw = new StringWriter();

		this.getJspBody().invoke(sw);
		StringBuffer data = sw.getBuffer();

		ListTag.processJspBodyReplacement(data,
				this.getFacade().getModalFooter());

		processRendererAttributeReplacement(data,
				this.getFacade().getModalFooter().getHandler());

		out.print(data.toString());
	}

}
