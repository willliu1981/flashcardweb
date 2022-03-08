package idv.kwl.handle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import idv.fc.dao.IDao;
import idv.fc.tool.SpringUtil;

public abstract class DataProcessController<T> extends AttributeController {
	private IDao<?> dao;
	private String modelStr;

	public IDao<?> getDao() {
		return dao;
	}

	public void setDao(IDao<?> dao) {
		this.dao = dao;
	}

	public T getModel() {
		return (T) SpringUtil.getBean(modelStr);
	}

	public void setModel(String modelStr) {
		this.modelStr = modelStr;
	}

}
