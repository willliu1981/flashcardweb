package idv.fc.quiz.playstrategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.filterimpl.CommonFilter;
import idv.fc.quiz.playstrategy.filterimpl.PeriodFilter;
import idv.fc.quiz.playstrategy.modimpl.ProficiencyMod;
import idv.fc.quiz.playstrategy.modimpl.RandomMod;
import idv.fc.quiz.playstrategy.modimpl.TimeMod;

@Component
public class QuizPlayStrategyContextFactory
		implements FactoryBean<QuizPlayStrategyContext<HolderDataDTO>> {

	@Autowired
	private PeriodFilter periodFilter;

	@Autowired
	private CommonFilter commonFilter;

	@Autowired
	private RandomMod randomMod;

	@Autowired
	private ProficiencyMod proficiencyMod;

	@Autowired
	private TimeMod timeMod;

	@Override
	public QuizPlayStrategyContext<HolderDataDTO> getObject() throws Exception {
		Map<String, QuizFilter<HolderDataDTO>> filters = new HashMap<>();
		filters.put("period", periodFilter);
		filters.put("common", commonFilter);

		Map<String, QuizMod<HolderDataDTO>> mods = new HashMap<>();
		mods.put("random", randomMod);
		mods.put("proficiency", proficiencyMod);
		mods.put("time", timeMod);

		return new QuizPlayStrategyContext<HolderDataDTO>(filters, mods);
	}

	@Override
	public Class<?> getObjectType() {
		return QuizPlayStrategyContext.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
