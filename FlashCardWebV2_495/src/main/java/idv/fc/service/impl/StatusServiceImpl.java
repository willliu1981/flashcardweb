package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.excpetion.ExceptionFactory;
import idv.fc.dao.itf.StatusDao;
import idv.fc.model.Status;
import idv.fc.service.abstraction.IStatusService;

@Service("statusService")
public class StatusServiceImpl implements IStatusService {

	@Autowired
	StatusDao statusDao;

	@Override
	public List<Status> getAll() {
		/*return statusDao.selectAll();*/
		throw ExceptionFactory
				.getDefaultUnsupportedOperationException(new Object() {
				});
	}

	@Override
	public Status getById(String id) {
		try {
			return statusDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(Status model) {
		try {
			statusDao.create(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Status model) {
		try {
			statusDao.update(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			statusDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
