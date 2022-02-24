package idv.kwl.handle.controller;

import idv.kwl.dao.IDao;

public class DaoController<T> extends AttributeController {
	private IDao<T> dao;
	private T model;

	public IDao<T> getDao() {
		return dao;
	}

	public void setDao(IDao<T> dao) {
		this.dao = dao;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
