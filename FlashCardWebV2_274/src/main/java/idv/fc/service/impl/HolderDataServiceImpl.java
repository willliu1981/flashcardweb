package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.debug.Debug;
import idv.fc.dao.itf.HolderDataDao;
import idv.fc.dao.itf.StatusDao;
import idv.fc.model.HolderData;
import idv.fc.model.Status;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.service.abstraction.IHolderDataService;

@Service("holderDataService")
public class HolderDataServiceImpl implements IHolderDataService {

	@Autowired
	private HolderDataDao holderDataDao;

	@Autowired
	private StatusDao statusDao;

	@Override
	public List<HolderData> getAll() {
		return holderDataDao.selectAll();
	}

	@Override
	public HolderData getById(String id) {
		try {
			return holderDataDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(HolderData holderData) {
		try {
			Status status = new Status();
			statusDao.create(status);

			holderData.setStatusId(status.getId());
			holderDataDao.create(holderData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(HolderData holderData) {
		try {
			holderDataDao.update(holderData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			holderDataDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<HolderDataDTO> getAllJoinFH() {
		return this.holderDataDao.selectAllJoinFh();
	}

	/**
	 * mod 來自quizmanagedPage.jsp 的radioMod 值
	 */
	@Override
	public List<HolderDataDTO> getAllJoinFH(String mod, Integer num) {
		List<HolderDataDTO> resultList = null;

		//決策
		if (mod.equals("period")) {
			List<HolderDataDTO> all = this.holderDataDao.selectAllJoinFh();
			List<HolderDataDTO> filterTime = all.stream().filter(x -> {
				if (x.getStatus().getEndTimeOfPhase() == null) {
					return true;
				}
				return x.getStatus().getEndTimeOfPhase().before(new Date());
			}).collect(Collectors.toList());

			resultList = filterTime.stream().collect(Collectors
					.collectingAndThen(Collectors.toList(), collected -> {
						Collections.shuffle(collected);
						return collected.stream();
					})).limit(num).collect(Collectors.toList());

		} else {
			resultList = this.holderDataDao.selectAllJoinFh();
		}

		return resultList;
	}

}
