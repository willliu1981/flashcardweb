package idv.kw.tag.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.CC;
import idv.debug.Debug;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.HolderDataDTO;
import idv.kw.tag.factory.FacadeFactory;
import idv.kw.tag.itf.TagFacade;

public class SetEditorTag<T extends TagFacade> extends SimpleTagSupport {
	private final String SCOPE_PAGE = "page";
	private final String SCOPE_REQUEST = "request";

	private Class<T> type;
	private String data = "data";
	private String var = "editor";
	private String scope = SCOPE_PAGE;

	@Override
	public void doTag() throws JspException, IOException {

	}

	protected TagFacade getFacade() {
		HttpServletRequest request = (HttpServletRequest) ((PageContext) this
				.getJspContext()).getRequest();

		Object attribute = request.getAttribute(data);
		return FacadeFactory.getFacade(attribute, type, attribute.getClass());
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setType(Class<T> editorType) {
		this.type = editorType;

		TagFacade facade = this.getFacade();
		if (this.scope.equals(SCOPE_PAGE)) {
			this.getJspContext().setAttribute(this.var, facade);
		} else if (this.scope.equals(SCOPE_REQUEST)) {
			HttpServletRequest request = (HttpServletRequest) ((PageContext) this
					.getJspContext()).getRequest();
			request.setAttribute(this.var, facade);
		}
	}
}
