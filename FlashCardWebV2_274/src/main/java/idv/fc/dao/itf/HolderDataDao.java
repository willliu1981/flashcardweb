package idv.fc.dao.itf;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.dto.HolderDataDTO;
import idv.fc.model.HolderData;

@Repository
public interface HolderDataDao extends Dao<HolderData> {

	List<HolderDataDTO> selectAllJoinFh();
}
