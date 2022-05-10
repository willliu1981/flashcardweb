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

public class FacadeTag<T extends ListFacade> extends SimpleTagSupport {

	private String facadeType;
	private String datas = "_datas";
	private String var = "_facade";//default var

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
		Debug.test(this, "datas", datas);
		Class<T> clazz;
		try {
			clazz = (Class<T>) Class.forName(this.facadeType);

			HttpServletRequest request = (HttpServletRequest) ((PageContext) this
					.getJspContext()).getRequest();

			List attrDatas = (List) request.getAttribute(datas);

			Debug.test(this, "list", attrDatas);
			ListFacade listFacade = ListFacadeFactory.getListFacade(attrDatas,
					clazz);

			this.getJspContext().setAttribute(var, listFacade);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
