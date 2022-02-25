package idv.kwl.handle.controller;

import idv.kwl.dao.IDao;

public class DaoController<T> extends AttributeController {
	private IDao dao;
	private T model;

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
