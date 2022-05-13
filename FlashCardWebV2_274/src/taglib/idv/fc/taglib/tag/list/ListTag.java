package idv.fc.taglib.tag.list;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.taglib.factory.ListFacade;
import tool.taglib.Taglibs;

public class ListTag extends SimpleTagSupport {
	private ListFacade facade;//定使用private , 避免直接取得未處理過的 facade

	public void setListFacade(ListFacade facade) {
		this.facade = facade;
		/*String contextPath = ((PageContext) getJspContext()).getServletContext()
				.getContextPath();
		this.facade.setContextPath(contextPath);*/
	}

	protected ListFacade getFacade() {
		if (this.facade == null) {
			HttpServletRequest request = (HttpServletRequest) ((PageContext) this
					.getJspContext()).getRequest();
			String var = (String) request
					.getAttribute(Taglibs.FacadeTag_FACADE_VAR_KEY);

			ListFacade facade = (ListFacade) request.getAttribute(var);

			return facade;
		}

		return this.facade;
	}

}
