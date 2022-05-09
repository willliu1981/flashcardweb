package idv.fc.taglib.tag.listgroup;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ItemTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		try {
			this.getJspBody().invoke(null);
		} catch (JspException | IOException e) {
			throw new RuntimeException(e);
		}
	}

}
