package idv.fc.service.abstraction;

import java.util.List;

import idv.fc.model.HolderData;
import idv.fc.model.dto.HolderDataDTO;

public interface IHolderDataService extends IService<HolderData> {

	List<HolderDataDTO> getAllJoinFH();

	List<HolderDataDTO> getAllJoinFHWithFilterAndMod(String mod, String detail, Integer num);
	
	void updateForQuizFinish(Integer[]  datas, String filter);

	HolderDataDTO getDTOById(String id);

}
