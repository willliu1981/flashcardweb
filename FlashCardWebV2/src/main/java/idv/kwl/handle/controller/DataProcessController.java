package idv.kwl.handle.controller;

import idv.kwl.bean.factory.SpringUtil;
import idv.kwl.dao.IDao;

public class DataProcessController<T> extends AttributeController {
	private IDao<?> dao;
	private String modelStr;
	private T model;

	public IDao<?> getDao() {
		return dao;
	}

	public void setDao(IDao<?> dao) {
		this.dao = dao;
	}

	public String getModel() {
		return modelStr;
	}

	public void setModel(String modelStr) {
		this.modelStr = modelStr;
	}

	@Override
	protected void start() {
		super.start();
		this.model = (T) SpringUtil.getBean(modelStr);
	}

}
