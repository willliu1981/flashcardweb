package idv.fc.service.abstraction;

import java.util.List;

import com.github.pagehelper.Page;

import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.FlashcardHolderListDTO;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;

public interface IFlashcardHolderService extends IService<FlashcardHolder> {

	List<FlashcardHolderDTO> getAllJoinFc();

	SimplePageInfoDTO getAllWithSimplePageInfoDTO(Page<Object> startPage, int maxNavPageNums);

}
