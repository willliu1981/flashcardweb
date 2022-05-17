package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.fc.dao.itf.HolderDataDao;
import idv.fc.model.HolderData;
import idv.fc.service.abstraction.IHolderDataService;

@Service("holderDataService")
public class HolderDataServiceImpl implements IHolderDataService {

	@Autowired
	private HolderDataDao HolderDataDao;

	@Override
	public List<HolderData> getAll() {
		return HolderDataDao.selectAll();
	}

	@Override
	public HolderData getById(String id) {
		try {
			return HolderDataDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(HolderData holderData) {
		try {
			HolderDataDao.create(holderData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(HolderData holderData) {
		try {
			HolderDataDao.update(holderData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			HolderDataDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
