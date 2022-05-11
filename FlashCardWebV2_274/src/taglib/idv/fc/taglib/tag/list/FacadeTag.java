package idv.fc.taglib.tag.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.taglib.component.facade.ListFacade;
import idv.taglib.component.facade.FacadeFactory;
import tool.Debug;
import tool.taglib.Taglibs;

public class FacadeTag<T extends ListFacade> extends SimpleTagSupport {

	private Class<ListFacade> facadeType;
	private String datas = Taglibs.FacadeTag_DATAS;//default datas var
	private String var = Taglibs.FacadeTag_FACADE_VAR;//default facade var

	public void setVar(String var) {
		this.var = var;
	}

	public void setFacadeType(Class<ListFacade> type) {
		this.facadeType = type;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	@Override
	public void doTag() throws JspException, IOException {
		HttpServletRequest request = (HttpServletRequest) ((PageContext) this
				.getJspContext()).getRequest();
		List<?> attrDatas = (List<?>) request.getAttribute(datas);

		ListFacade listFacade = FacadeFactory.getListFacade(attrDatas,
				facadeType);
		listFacade.setContextPath(request.getContextPath());

		request.setAttribute(Taglibs.FacadeTag_FACADE_VAR_KEY, var);
		request.setAttribute(var, listFacade);

	}

}
