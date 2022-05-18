package idv.fc.dao.itf;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.HolderData;
import idv.fc.model.dto.HolderDataDTO;

@Repository
public interface HolderDataDao extends Dao<HolderData> {

	List<HolderDataDTO> selectAllJoinFh();
}
