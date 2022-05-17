package idv.fc.service.abstraction;

import java.util.List;

import idv.fc.dto.HolderDataDTO;
import idv.fc.model.HolderData;

public interface IHolderDataService extends IService<HolderData> {

	List<HolderDataDTO> getAllJoinFH();

}
