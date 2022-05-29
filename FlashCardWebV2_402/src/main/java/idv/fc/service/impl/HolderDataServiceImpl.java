package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import idv.fc.dao.itf.HolderDataDao;
import idv.fc.dao.itf.StatusDao;
import idv.fc.model.HolderData;
import idv.fc.model.Status;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.strategy.QuizModStrategyContext;
import idv.fc.quiz.strategy.QuizModStrategyContextFactory;
import idv.fc.service.abstraction.IHolderDataService;
import idv.fc.service.abstraction.IStatusService;

@Service("holderDataService")
public class HolderDataServiceImpl implements IHolderDataService {

	@Autowired
	private HolderDataDao holderDataDao;

	@Autowired
	private StatusDao statusDao;

	@Autowired
	private IStatusService statusService;

	@Autowired
	//@Qualifier("strategyContext")
	private QuizModStrategyContext<HolderDataDTO> strategyContext;

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
			statusService.addNew(status);

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
			/*holderDataDao.delete(id);*/
			//藉由刪除status 由sql 自動(連瑣)刪除 holderData 
			Integer statusId = holderDataDao.selectById(id).getStatusId();
			statusService.remove(statusId.toString());
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
	public List<HolderDataDTO> getAllJoinFH(String mod, String detail,
			Integer num) {
		List<HolderDataDTO> all = this.holderDataDao.selectAllJoinFh();

		strategyContext.setStrategy(mod);

		return strategyContext.executeStrategy(all, num);
	}

}
