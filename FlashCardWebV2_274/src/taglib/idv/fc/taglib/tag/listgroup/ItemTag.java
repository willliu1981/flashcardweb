package idv.fc.taglib.tag.listgroup;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.FlashcardListFacade;
import idv.fc.taglib.component.common.TaglibRenderer;

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
