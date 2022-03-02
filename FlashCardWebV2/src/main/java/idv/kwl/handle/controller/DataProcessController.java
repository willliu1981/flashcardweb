package idv.kwl.handle.controller;

import idv.kwl.dao.IDao;
import idv.kwl.tool.SpringUtil;

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

	public T getModel() {
		if (this.modelStr != null && this.model == null) {
			this.model = (T) SpringUtil.getBean(modelStr);
		}
		return this.model;
	}

	public void setModel(String modelStr) {
		this.modelStr = modelStr;
	}

	@Override
	protected void start() {
		super.start();
		this.model = null;
	}

}
