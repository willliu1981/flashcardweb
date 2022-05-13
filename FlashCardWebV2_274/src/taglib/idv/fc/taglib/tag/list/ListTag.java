package idv.fc.taglib.tag.list;

import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import idv.taglib.control.Handler;
import idv.taglib.control.Result;
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

	//處理 由jsp傳來的 body ,取代 result 中 Handler.BODY 佔位符的位置
	protected static void processJspBodyReplacement(StringBuffer buffer,
			Result result) {
		String modalBody = result.getStrResult();
		String jspBody = buffer.toString();

		buffer.setLength(0);
		buffer.append(modalBody);
		int indexOf = buffer.indexOf(Handler.BODY);
		buffer.replace(indexOf, indexOf + Handler.BODY.length(), jspBody);

	}

	//處理 handler 中, 以 attributes 遍歷並取代 buffer 所有佔位符的位置 
	protected static void processRendererAttributeReplacement(
			StringBuffer buffer, Handler handler) {

		//替換 attribute
		handler.getAttributes().forEach((k, v) -> {
			Pattern compile = Pattern
					.compile("\\{[ ]*" + k.trim() + "*[ ]*\\}");
			Matcher matcher = compile.matcher(buffer.toString());
			String replaceAll = matcher.replaceAll(v);
			buffer.setLength(0);
			buffer.append(replaceAll);
		});

	}

}
