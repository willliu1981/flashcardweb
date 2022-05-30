package idv.fc.quiz.playstrategy.filterimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.QuizFilter;

@Repository("commonFilter")
public class CommonFilter implements QuizFilter<HolderDataDTO> {

	@Override
	public List<HolderDataDTO> doOperation(List<HolderDataDTO> origDatas) {

		return origDatas;
	}

}
