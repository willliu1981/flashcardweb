package idv.fc.quiz.playstrategy.modimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.QuizMod;

@Repository("defaultMod")
public class DefaultMod implements QuizMod<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			Integer num) {

		return origDatas.stream().limit(num).collect(Collectors.toList());
	}

}
