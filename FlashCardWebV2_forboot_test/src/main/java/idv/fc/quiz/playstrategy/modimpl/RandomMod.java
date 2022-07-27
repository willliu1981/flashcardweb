package idv.fc.quiz.playstrategy.modimpl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import idv.debug.Debug;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.QuizMod;

@Repository("randomMod")
public class RandomMod implements QuizMod<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas,
			Integer num) {

		List<HolderDataDTO> collect = origDatas.stream().collect(
				Collectors.collectingAndThen(Collectors.toList(), collected -> {
					Collections.shuffle(collected);
					return collected.stream();
				})).limit(num).collect(Collectors.toList());

		return collect;
	}

}
