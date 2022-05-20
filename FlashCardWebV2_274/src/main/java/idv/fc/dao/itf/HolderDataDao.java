package idv.fc.dao.itf;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.HolderData;
import idv.fc.model.dto.HolderDataDTO;

@Repository
public interface HolderDataDao extends Dao<HolderData> {

	default List<HolderDataDTO> selectAllJoinFh() {
		return this.selectAllJoinFh(null);
	}

	List<HolderDataDTO> selectAllJoinFh(Integer status_id);
}
