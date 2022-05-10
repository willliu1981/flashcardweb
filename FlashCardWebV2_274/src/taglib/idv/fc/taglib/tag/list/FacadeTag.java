package idv.fc.taglib.tag.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.fc.taglib.component.ListFacade;
import idv.fc.taglib.component.ListFacadeFactory;
import tool.Debug;
import tool.taglib.Taglibs;

public class FacadeTag<T extends ListFacade> extends SimpleTagSupport {

	private String facadeType;
	private String datas = Taglibs.FacadeTag_DATAS;//default datas var
	private String var = Taglibs.FacadeTag_FACADE_VAR;//default facade var

	public void setVar(String var) {
		this.var = var;
	}

	public void setFacadeType(String type) {
		this.facadeType = type;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Class<T> clazz;
		try {
			HttpServletRequest request = (HttpServletRequest) ((PageContext) this
					.getJspContext()).getRequest();
			List attrDatas = (List) request.getAttribute(datas);

			clazz = (Class<T>) Class.forName(this.facadeType);
			ListFacade listFacade = ListFacadeFactory.getListFacade(attrDatas,
					clazz);
			listFacade.setContextPath(request.getContextPath());

			request.setAttribute(Taglibs.FacadeTag_FACADE_VAR_KEY, var);
			request.setAttribute(var, listFacade);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
